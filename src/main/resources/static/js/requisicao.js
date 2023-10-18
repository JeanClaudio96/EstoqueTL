function adicionarLinha() {
    var indice = $('#linhasExtra .linha-material').length + 1;
    var linha = `
        <div class="linha-material form-row mb-3">
            <div class="col"><input type="text" class="form-control" placeholder="Sigla" name="materiais[${indice}].sigla" required></div>
            <div class="col">
                <select type="text" class="form-control" id="tipoMaterialSelect" name="materiais[${indice}].tipoMaterial" required>
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
                <select type="text" class="form-control" id="unidadeDeMedidaSelect" name="materiais[${indice}].unidadeDeMedida" required>
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

$(document).ready(function() {
    // Inicializa o Autocomplete no campo #sigla
    $('#sigla').autocomplete({
        source: estoqueList.map(function(estoque) {
            return estoque.sigla;
        }),
        select: function(event, ui) {
            var siglaSelecionada = ui.item.value;
            var estoque = estoqueList.find(function(item) {
                return item.sigla === siglaSelecionada;
            });

            if (estoque) {
                // Preenche os campos
                // ...

                // Desabilita apenas os campos que devem ser desabilitados
                $('#tipoMaterialSelect').prop('disabled', true);
                $('#nome').prop('disabled', true);
                $('#descricao').prop('disabled', true);
                $('#unidadeDeMedidaSelect').prop('disabled', true);
            } else {
                // Limpa os campos
                // ...

                // Habilita apenas os campos que devem ser habilitados
                $('#tipoMaterialSelect').prop('disabled', false);
                $('#nome').prop('disabled', false);
                $('#descricao').prop('disabled', false);
                $('#unidadeDeMedidaSelect').prop('disabled', false);
            }

        }
    });

    // Ouvinte de eventos para o campo #sigla (evento de entrada)
    $('#requisicaoForm').on('input', '#sigla', function() {
        // Lógica de filtro de sugestões, se necessário
    });
});


