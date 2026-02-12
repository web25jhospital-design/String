//--- ikusi behar da produktuaren informazioa eta gero botoi bat non informazio gehiago ikusiko da eta gero beste orrialde 
// batean ikusiko da produktuaren informazioa eta erosteko aukera izango da
//ikusteko produktu zerrenda

const container = document.querySelector("#products_list");
const datuakgorde = localStorage.getItem("products");

function create_products_list() {
    if (datuakgorde) {

        const productuak = JSON.parse(datuakgorde);

        productuak.forEach(produktua => {

            const tarjeta = document.createElement("div");


            tarjeta.innerHTML = `
            <h3>${produktua.Izena}</h3>
            <p>Id Produktua: ${produktua.Id}</p>
            <p>Deskribapena: ${produktua.Deskribapena}</p>
            <p>Pisua: ${produktua.Pisua}gr</p>
            <p>Prezio: ${produktua.Prezioa}€</p>
            <p>Stock: ${produktua.Stock}</p>
            <button class="informaziogehiago" onclick="info_gehiago(${produktua.Id})">Informazio gehiago</button>
        
             <hr>
        `;

            container.appendChild(tarjeta);
        });

    } else {
        //Ez bada dago produkturik, mensaje hau erakutziko da.
        container.innerHTML = "<p>Ez dago produkturik oraindik, eskerrik asko pasatzeagaitik ikusteko gure produktuak.</p>";
    }

}

function info_gehiago(id) {
    localStorage.setItem("selected_product_id", id);
    window.location.href = `product-details.html`;
}
// --- button bat egin behar da erosteko
//---- usuarioa click egin duena informazio dana erakutsiko da 

console.log("Produktuen zerrenda kargatzen...");
create_products_list();


function fill_product_info() {
    const selectedProductId_ = localStorage.getItem("selected_product_id");
    const datuakgorde = localStorage.getItem("products");

    if (datuakgorde && selectedProductId_) {
        const productuak = JSON.parse(datuakgorde);
        const produktua = productuak.find(p => p.Id == selectedProductId_);

        if (produktua) {
            const container = document.querySelector("#info");
            // Hemen innerHTML bakarrik erabiltzea nahikoa da
            container.innerHTML = `
                <h2>${produktua.Izena}</h2>
                <p>Id: ${produktua.Id}</p>
                <p>Deskribapena: ${produktua.Deskribapena}</p>
                <p>Prezioa: ${produktua.Prezioa}€</p>
                <label>Kantitatea: </label>
                <input type="number" id="kantitatea" value="1" min="1">
                <button class="erosi" onclick="erostekoEtaJoan()">Erosi</button>
            `;
        }
    }
}

fill_product_info();

function erostekoEtaJoan() {
    const kantitatea = document.querySelector("#kantitatea").value;
    localStorage.setItem("kantitatea", kantitatea); // Kantitatea gordetzen dugu
    window.location.href = "payment_1.html";
}
// ---- erakutsi behar du zer seleccionatu egin den erosteko eta gero joan egin behar da orrialde batera non or esan behr du erosi duzu x produktua
function fill_payment_cards1() { }
 const selectedProductId_ = localStorage.getItem("selected_product_id");
    const datuagorde = localStorage.getItem("products");
    if (datuagorde) {
        const selectedProductId = document.createElement("div");
        const productuak = JSON.parse(datuagorde);
        const produktua = productuak.find(p => p.Id == selectedProductId_);
        if (produktua) {
            const container = document.querySelector("#fill_cards");
            container.innerHTML = `
                <h2> Hau ordaintzeko informazioa da</h2>
                <p>Produktua: ${produktua.Izena}</p>
                <p>Prezioa: ${produktua.Prezioa}€</p>
            `;
            container.appendChild(selectedProductId);
        }
    } else {
        console.log("Ez dago produkturik gordeta.");
    }

//--- kantitatea eta produktua gorde egingo du eta beste orrialde batean ipini behar du produktuaren informazio eta gero checkout
// emaneskero eraman behar da beste orrialde batera non esan behar du print.html dagoena.
// kantitatea bebai ikusiko da eta gero produktua eta kantitatea gordeko dira localStorage-n eta gero print.html orrialdean erakutsiko da.
function fill_payment_cards1() {
    const selectedProductId_ = localStorage.getItem("selected_product_id");
    const kantitatea = localStorage.getItem("kantitatea");
    const datuagorde = localStorage.getItem("products");

    if (datuagorde && selectedProductId_) {
        const productuak = JSON.parse(datuagorde);
        const produktua = productuak.find(p => p.Id == selectedProductId_);

        if (produktua) {
            const container = document.querySelector("#fill_cards");
            container.innerHTML = `
                <h2>Hau ordaintzeko informazioa da</h2>
                <p>Produktua: <strong>${produktua.Izena}</strong></p>
                <p>Kantitatea: ${kantitatea}</p>
                <p>Guztira: ${produktua.Prezioa * kantitatea}€</p>
                <button onclick="window.location.href='print.html'">Ordaindu</button>
            `;
        }
    }
}


fill_payment_cards1();

