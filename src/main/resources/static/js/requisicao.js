function adicionarLinha() {
    var indice = $('#linhasExtra .linha-material').length;
    var linha = `
        <div class="linha-material form-row mb-3">
            <div class="col"><input type="text" class="form-control" placeholder="Sigla" name="materiais[${indice}].sigla" required></div>
            <div class="col">
                <select type="text" class="form-control" id="valorDropdown" name="materiais[${indice}].tipo" required>
                    <option value="ELETRICO">Elétrico</option>
                    <option value="CIVIL">Civil</option>
                    <option value="HIDRAULICO">Hidráulico</option>
                    <option value="VESTIMENTA">Vestimenta</option>
                    <option value="EPI">EPI</option>
                    <option value="EPC">EPC</option>
                    <option value="FERRAMENTA">Ferramenta</option>
                </select>
            </div>
            <div class="col"><input type="text" class="form-control" placeholder="Nome" name="materiais[${indice}].nome" required></div>
            <div class="col"><input type="text" class="form-control" placeholder="Descrição" name="materiais[${indice}].descricao" required></div>
            <div class="col">
                <select type="text" class="form-control" id="valorDropdown" name="materiais[${indice}].unidadeDeMedida" required>
                    <option value="M">M</option>
                    <option value="M2">M²</option>
                    <option value="M3">M³</option>
                    <option value="UND">UND</option>
                </select>
            </div>
            <div class="col"><input type="number" step="any" class="form-control" placeholder="Quantidade" name="materiais[${indice}].quantidadeRequisitada"></div>
            <div class="col"><input type="checkbox" id="checkbox" name="materiais[${indice}].devolucao"></div>
            <div class="col"><input type="number" step="any" class="form-control" placeholder="Quantidade" name="materiais[${indice}].quantidadeDevolvida"></div>
        </div>
    `;
    $('#linhasExtra').append(linha);
}

function limparCampos() {
	document.getElementById('requisicaoForm').reset();
	document.getElementById('linhasExtra').innerHTML = '';
}