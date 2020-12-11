

// toggle sidebar
document.querySelector('.header__toggle').addEventListener('click' , ()=>{
  navbar = document.querySelector('.navbar')
    navbar.classList.toggle('expander')
    document.querySelector('.header__toggle').classList.toggle('fix-menu-icon')
    document.querySelector('.side-bar').classList.toggle('fix-side-bar')

    
})

//initialize cards
let active_companies =document.querySelector('#number-of-active-companies')
 
// user profile modal
document.querySelector('.chevron').addEventListener('click' , ()=>{
  document.querySelector('.user-infos').classList.toggle('user-infos-show')
})


// dropdowns 
document.querySelector('#users-dropdown').addEventListener('click' , ()=>{

  document.querySelectorAll('.hidden-dp-1').forEach((item)=>{
    item.classList.toggle('show')
  })
})
document.querySelector('#acsses-dropdown').addEventListener('click' , ()=>{

  document.querySelectorAll('.hidden-dp-2').forEach((item)=>{
    item.classList.toggle('show')
  })
})






// fetch('http://localhost:8086/companySize')
//     .then(response => response.json())
//     .then(res => console.log(res))
fetch('http://localhost:8086/companySize')
    .then(response =>{
      console.log(response)
      return response.json()
    } )
    .then(res =>{
        console.log(res)
        active_companies.innerHTML = res
    } )



