function buscar(){

let origem =
document.getElementById("origem").value;

let destino =
document.getElementById("destino").value;

let resultado =
document.getElementById("resultado");

resultado.innerHTML="";

resultado.innerHTML +=
"<hr>";

resultado.innerHTML +=
"<h3>Resultado</h3>";

resultado.innerHTML +=
"<p><b>Origem:</b> "
+ origem +
"</p>";

resultado.innerHTML +=
"<p><b>Destino:</b> "
+ destino +
"</p>";

resultado.innerHTML +=
"<p>Motorista: João Silva</p>";

resultado.innerHTML +=
"<p>Vagas: 3</p>";

resultado.innerHTML +=
"<button onclick='alert(\"Solicitação enviada!\")'>Solicitar Carona</button>";

}
