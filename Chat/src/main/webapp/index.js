var wsUri = "ws://172.16.4.114:8080/Chat/websocket";
var ws = new WebSocket(wsUri);

ws.onopen = (event)=>{
	//print("connected to : " + wsUri);
};

ws.onmessage = (event)=>{
	let msg = event.data;
	print(msg);
};

ws.onerror = (event)=>{
	print("error");
}

function print(msg){
	let textObject = document.getElementById("text");
	let text = textObject.value;
	textObject.innerHTML += ("<br>" + msg); 
}

function sendMessage(){
	
	let username 	= document.getElementById("username").value;
	let message 	= document.getElementById("message").value;
	ws.send( username + ": " + message);
	message.value = "";
}


