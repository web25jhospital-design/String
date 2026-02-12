// Función para listar productos en inner-page-products.html
function create_products_list() {
    const container = document.querySelector("#products_list");
    const datuakgorde = localStorage.getItem("products");

    if (!container) return; // Si no estamos en la página de productos, no hace nada

    if (datuakgorde) {
        const productuak = JSON.parse(datuakgorde);
        container.innerHTML = ""; // Limpiamos antes de cargar

        productuak.forEach(produktua => {
            const tarjeta = document.createElement("div");
            tarjeta.className = "col-md-4 mb-4"; // Añadimos clase para que quede bonito
            tarjeta.innerHTML = `
                <div class="card p-3 h-100">
                    <h3>${produktua.Izena}</h3>
                    <p><strong>Prezioa:</strong> ${produktua.Prezioa}€</p>
                    <p>${produktua.Deskribapena}</p>
                    <button class="btn btn-warning" onclick="info_gehiago(${produktua.Id})">Informazio gehiago</button>
                </div>
                <hr>
            `;
            container.appendChild(tarjeta);
        });
    } else {
        container.innerHTML = "<p>Ez dago produkturik oraindik.</p>";
    }
}

function info_gehiago(id) {
    localStorage.setItem("selected_product_id", id);
    window.location.href = `product-details.html`;
}

// Función para ver detalles en product-details.html
function fill_product_info() {
    const container = document.querySelector("#info");
    if (!container) return;

    const selectedProductId_ = localStorage.getItem("selected_product_id");
    const datuakgorde = localStorage.getItem("products");

    if (datuakgorde && selectedProductId_) {
        const productuak = JSON.parse(datuakgorde);
        const produktua = productuak.find(p => p.Id == selectedProductId_);

        if (produktua) {
            container.innerHTML = `
                <h2>${produktua.Izena}</h2>
                <p><strong>Id:</strong> ${produktua.Id}</p>
                <p><strong>Deskribapena:</strong> ${produktua.Deskribapena}</p>
                <p><strong>Prezioa:</strong> ${produktua.Prezioa}€</p>
                <div class="mt-3">
                    <label>Kantitatea: </label>
                    <input type="number" id="kantitatea" value="1" min="1" class="form-control d-inline-block" style="width: 80px;">
                    <button class="btn btn-primary ms-2" onclick="erostekoEtaJoan()">Erosi</button>
                </div>
            `;
        }
    }
}

function erostekoEtaJoan() {
    const kantitatea = document.querySelector("#kantitatea").value;
    localStorage.setItem("kantitatea", kantitatea);
    window.location.href = "payment_1.html";
}

// Función para el carrito en payment_1.html
function fill_payment_cards1() {
    const container = document.querySelector("#fill_cards");
    if (!container) return;

    const selectedProductId_ = localStorage.getItem("selected_product_id");
    const kantitatea = localStorage.getItem("kantitatea") || 1;
    const datuagorde = localStorage.getItem("products");

    if (datuagorde && selectedProductId_) {
        const productuak = JSON.parse(datuagorde);
        const produktua = productuak.find(p => p.Id == selectedProductId_);

        if (produktua) {
            container.innerHTML = `
                <div class="p-3 border rounded shadow-sm">
                    <h2>Hau ordaintzeko informazioa da</h2>
                    <p>Produktua: <strong>${produktua.Izena}</strong></p>
                    <p>Kantitatea: ${kantitatea}</p>
                    <p class="h4">Guztira: <span class="text-primary">${produktua.Prezioa * kantitatea}€</span></p>
                </div>
            `;
            // Actualizamos también el resumen lateral
            if(document.querySelector("#totalPrice")) {
                document.querySelector("#totalPrice").innerText = (produktua.Prezioa * kantitatea) + "€";
                document.querySelector("#price").innerText = (produktua.Prezioa * kantitatea) + "€";
                document.querySelector("#items").innerText = kantitatea + " items";
            }
        }
    }
}

// Función para ir a la página de éxito
function go2print() {
    window.location.href = "print.html";
}

// Función para mostrar el nombre en print.html
function bete_print() {
    const userSpan = document.querySelector("#user");
    if (userSpan) {
        userSpan.innerText = localStorage.getItem("username") || "Bezeroa";
    }
}

// Carga automática según la página
document.addEventListener("DOMContentLoaded", () => {
    create_products_list();
    fill_product_info();
    fill_payment_cards1();
    bete_print();
});