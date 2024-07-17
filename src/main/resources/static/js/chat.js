document.addEventListener('DOMContentLoaded', function (){
    const username = document.getElementById('username').textContent;
    const messageInput = document.getElementById('messageInput');
    const messagesDiv = document.getElementById('messages');
    let loginTime = new Date();

    const sendMessage = () => {
        const message = messageInput.value.trim();
        if(message){
                fetch('/sendMessage', {
                    method: 'post',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify({username: username , message: message, timestamp: new Date().toISOString() })
                }).then(response => {
                    if(response.ok){
                        messageInput.value = '';
                        fetchMessages();
                    }
            });
        }
    };

    const fetchMessages = () => {
        fetch('/getMessages')
            .then(response => response.json())
            .then(data => {
                messagesDiv.innerHTML = '';
                data.forEach(msg => {
                    const messageTime = new Date(msg.timestamp);
                    if (messageTime >= loginTime) {
                        const messageElement = document.createElement('div');
                        messageElement.textContent = `${msg.username}: ${msg.message}`;
                        messagesDiv.appendChild(messageElement);
                    }
                });
                messagesDiv.scrollTop = messagesDiv.scrollHeight;
            });
    };

    setInterval(fetchMessages, 500);

    messageInput.addEventListener('keypress', function(event){
        if (event.key ==='Enter') {
            event.preventDefault();
            sendMessage();
        }
    });

    fetchMessages();
});