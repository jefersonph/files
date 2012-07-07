
function confirmDelete(delUrl) {
  if (confirm("Deseja excluir?")) {
    document.location = delUrl;
  }
}

function zeraCombo(selected){

  selected.options[0].selected = "selected";
}
