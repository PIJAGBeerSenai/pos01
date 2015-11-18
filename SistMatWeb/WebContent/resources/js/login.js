function trocaAlunoColaborador (opcao){
	if (opcao == 1){
		document.getElementById("j_idt6:cpfPanel").style.display = 'block';
		document.getElementById("j_idt6:loginPanel").style.display = 'none';
	}else{
		document.getElementById("j_idt6:cpfPanel").style.display = 'none';
		document.getElementById("j_idt6:loginPanel").style.display = 'block';
	}
	
	
} 

