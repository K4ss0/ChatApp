document.addEventListener('DOMContentLoaded', function() {
    const usernameInput = document.getElementById('username');
    const loginPrompt = document.getElementById('loginPrompt');
    const loginDiv = document.getElementById('login');
    const channelsDiv = document.getElementById('channels');
    const generalChannel = document.getElementById('generalChannel');
    const privateChannel = document.getElementById('privateChannel');

    // Function to check login status and navigate to channel or show alert
    function navigateToChannel(channel) {
        const username = usernameInput.value.trim();
        if (username) {
            window.location.href = `/channels/${channel}?username=${username}`;
        } else {
            alert('Please log in with a valid username first.');
            window.location.href = '/login';
        }
    }

    // Add event listeners to the chat channels
    if (generalChannel) {
        generalChannel.addEventListener('click', function(event) {
            event.preventDefault();
            navigateToChannel('general');
        });
    }

    if (privateChannel) {
        privateChannel.addEventListener('click', function(event) {
            event.preventDefault();
            navigateToChannel('private');
        });
    }

    // Add event listener for the Enter key
    if (usernameInput) {
        usernameInput.addEventListener('keypress', function(event) {
            if (event.key === 'Enter') {
                event.preventDefault();
                const username = usernameInput.value.trim();
                if (username) {
                    var form = document.createElement('form');
                    form.method = 'POST';
                    form.action = '/login';

                    var hiddenField = document.createElement('input');
                    hiddenField.type = 'hidden';
                    hiddenField.name = 'username';
                    hiddenField.value = username;

                    form.appendChild(hiddenField);
                    document.body.appendChild(form);
                    form.submit();
                } else {
                    alert('Please enter a username.');
                }
            }
        });
    }
});
