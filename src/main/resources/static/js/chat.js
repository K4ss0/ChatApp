document.addEventListener('DOMContentLoaded', function (){
    const messageInput = document.getElementById('messageInput');
    const messagesDiv = document.getElementById('messages');

    messageInput.addEventListener('keypress', function (event){
        if (event.key === 'Enter'){
            event.preventDefault();
            const messageText = messageInput.value.trim();
            if (messageText){
                const messageElement = document.createElement('div');
                messageElement.classList.add('message');
                messageElement.textContent = messageText;
                messagesDiv.appendChild(messageElement);
                messageInput.value = '';
            }
        }
    });
});