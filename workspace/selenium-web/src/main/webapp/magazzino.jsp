<%@page import="model.Maglia"%>
<%@page import="java.util.List"%>
<table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Colore</th>
      <th scope="col">Scritta</th>
      <th scope="col">Taglia</th>
      <th scope="col">Prezzo</th>
    </tr>
  </thead>
  <tbody>
  
  
  <% List<Maglia> maglie = (List<Maglia>) request.getAttribute("maglie"); %>
  
  
  <% for(Maglia m :  maglie ){ %>
  
  
    <tr>
      <th scope="row">1</th>
      <td><%= m.getColore() %></td>
      <td><%= m.getScritta() %></td>
      <td><%= m.getTaglia() %></td>
      <td><%= m.getPrezzo() %></td>
    </tr>
    
  <% } %>  
    
    
   
  </tbody>
</table>
<button id="btn">Scarica prodotti</button>

<script>

	const TABLE = document.querySelector(".table > tbody")
	const BTN = document.getElementById('btn')
	
	BTN.onclick = function(){
			fetch('https://fakestoreapi.com/products')
		.then(response => response.json())
		.then(prodotti => {
			
			for (prodotto of prodotti){
				const IMG = document.createElement('img')
				IMG.setAttribute('src', prodotto.image)
				document.body.append(IMG)
				console.log(prodotto)
			}
			
		})
	}
	
	
	


</script>


















