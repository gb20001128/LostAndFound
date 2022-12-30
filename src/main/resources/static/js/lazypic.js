// window.onload = function () {
//     let imgs = document.querySelectorAll('.lazy')
//     function lazyload() {
//         let viewHeight = document.documentElement.clientHeight;
//         let scrollTop = document.documentElement.scrollTop || document.body.scrollTop;
//         for (let i = 0; i < imgs.length; i++) {
//             if (imgs[i].offsetTop < viewHeight + scrollTop) {
//                 imgs[i].src = imgs[i].getAttribute('data-src')
//             }
//         }
//     }
//     lazyload();
//     function thorttle(fn, wait) {
//         let timer = null
//         return function () {
//             if (!timer) {
//                 timer = setTimeout(() => {
//                     fn.call(this)
//                     timer = null
//                 }, wait)
//             }
//         }
//     }
//     window.onscroll = thorttle(lazyload, 500)
// }