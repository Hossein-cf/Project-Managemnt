

// toggle sidebar
document.querySelector('.header__toggle').addEventListener('click' , ()=>{
  navbar = document.querySelector('.navbar')
    navbar.classList.toggle('expander')
    document.querySelector('.header__toggle').classList.toggle('fix-menu-icon')
    document.querySelector('.side-bar').classList.toggle('fix-side-bar')

    
})
// user profile modal
document.querySelector('.chevron').addEventListener('click' , ()=>{
  document.querySelector('.user-infos').classList.toggle('user-infos-show')
})


document.querySelector('#project').addEventListener('click' , ()=>{

  document.querySelectorAll('.hidden-dp-2').forEach((item)=>{
    item.classList.toggle('show')
  })
})
document.querySelector('#Tickets').addEventListener('click' , ()=>{

  document.querySelectorAll('.hidden-dp-3').forEach((item)=>{
    item.classList.toggle('show')
  })
})


moment().locale('fa').format('YYYY/M/D');








