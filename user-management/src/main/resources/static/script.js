// src/main/resources/static/script.js

document.getElementById('addUserForm').addEventListener('submit', function (event) {
    event.preventDefault();
    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;

	fetch('/api/users', {  // Use absolute paths
	    method: 'POST',
	    headers: {
	        'Content-Type': 'application/json',
	    },
	    body: JSON.stringify({ name,email})
	})
    .then(response => response.json())
    .then(data => {
        alert('User added successfully!');
        loadUsers(); // Reload users after adding
    })
    .catch((error) => {
        console.error('Error:', error);
    });
});

function loadUsers() {
    fetch('api/users')
        .then(response => response.json())
        .then(users => {
            const userList = document.getElementById('users');
            userList.innerHTML = ''; // Clear the existing list
            users.forEach(user => {
                const li = document.createElement('li');
                li.textContent = `${user.name} (${user.email})`;
                userList.appendChild(li);
            });
        });
}

// Load users when the page loads
loadUsers();
