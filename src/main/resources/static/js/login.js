document.addEventListener('DOMContentLoaded',function () {
    document.getElementById('username').addEventListener('keypress', function (event) {
        if (event.key === 'Enter') {
            event.preventDefault();
            const username = event.target.value;
            if (username) {
                fetch('/login/api', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify({username: username})
                })
                    .then(response => response.json())
                    .then(data => {
                        console.log('API response:', data);
                        if (data.success) {
                            document.getElementById('login').style.display = 'none';
                            document.getElementById('user').textContent = username;
                            document.getElementById('chat').style.display = 'block';
                        } else {
                            alert('Login failed');
                        }
                    })
                    .catch(error => console.error('Error', error));
            }
        }
    });
});