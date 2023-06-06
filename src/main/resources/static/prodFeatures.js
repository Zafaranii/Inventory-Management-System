// send data
const addButton = document.getElementById('add-product')

// addButton.addEventListener('click', () => {
// })

const handleAdd = async () => {
    // const product_id = document.getElementById('product-id').value
    const product_name = document.getElementById('name').value
    const prod_type=document.getElementById('type').value
    const supplier = document.getElementById('supplier').value
    const price = document.getElementById('price').value
    const exp_date = document.getElementById('expiration').value
    const prod_date = document.getElementById('production').value
    const data = {
        // product_id: product_id,
        "name": product_name,
        "type": prod_type,
        "price": price,
        "expiration": exp_date,
        "production": prod_date,
        "supplier": supplier,
    }
    console.log(data);
    const response = await fetch('localhost:8080', {
        method:'POST',
        body:JSON.stringify(data),
        headers:{
            'Content-Type':'application/json'
        }
    })
    const json = await response.json()
    if (response.ok) {
        document.getElementById('successful').innerHTML = "Data Sent Successfully"
        document.getElementById('successful').innerHTML = json
    }
    if (!response.ok) {
        document.getElementById('error').innerHTML = "Error happened"
        document.getElementById('error').innerHTML = json.error
    }
}

addButton.onclick = handleAdd()