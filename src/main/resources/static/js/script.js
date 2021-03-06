fetch('film')
    .then(res => res.json())
    .then(res => {
        var invoiceListNode = document.getElementById('film-list');
        invoiceListNode.innerHTML = "";

        var table = document.createElement("table");
        table.setAttribute("border","1");
        invoiceListNode.appendChild(table);

        res.forEach(film => {

            var tr = document.createElement("tr");
            table.appendChild(tr);

            var td = document.createElement("td");
            var text = document.createTextNode(`${film.titre}`);
            td.appendChild(text);
            tr.appendChild(td);

            td = document.createElement("td");
            text = document.createTextNode(`${film.genre}`);
            td.appendChild(text);
            tr.appendChild(td);

            td = document.createElement("td");
            var button = document.createElement("button");
            button.setAttribute("type","button");
            button.onclick = function() {
                showDetail(`${film.id}`);
            };
            text = document.createTextNode("Details");
            button.appendChild(text);
            td.appendChild(button);
            tr.appendChild(td);


        });

    });


function showDetail(id){
    fetch("film/"+id)
    .then(res => res.json())
    .then(res => {
        var invoiceDetailNode = document.getElementById('film-detail');
        invoiceDetailNode.innerHTML = "";

        var p = document.createElement("p");
        var text = document.createTextNode(`Titre: ${res.titre}`);
        p.appendChild(text);
        invoiceDetailNode.appendChild(p);

        p = document.createElement("p");
        text = document.createTextNode(`Genre: ${res.genre}`);
        p.appendChild(text);
        invoiceDetailNode.appendChild(p);

        p = document.createElement("p");
        text = document.createTextNode(`Description: ${res.description}`);
        p.appendChild(text);
        invoiceDetailNode.appendChild(p);

        p = document.createElement("p");
        text = document.createTextNode(`Main acteur: ${res.mainActeur.firstName} ${res.mainActeur.lastName}`);
        p.appendChild(text);
        invoiceDetailNode.appendChild(p);

        p = document.createElement("p");
        var sum = res.reviews.map((a) => a.mark).reduce((a, b) => a + b, 0);
        var avg = (sum / res.reviews.length) || 0;
        text = document.createTextNode(`Mark: ${avg}/5`);
        p.appendChild(text);
        invoiceDetailNode.appendChild(p);
    });
}