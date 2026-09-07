<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Contact</title>

<style>
*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:Segoe UI, sans-serif;
}

body{
    background:#f4f6f9;
}

#contact{
    width:100%;
    padding:30px 20px;
}

.contact-box{
    max-width:900px;
    margin:auto;
    background:white;
    border-radius:20px;
    box-shadow:0 15px 40px rgba(0,0,0,.1);
    padding:50px;
}

.contact-box h2{
    font-size:40px;
    color:#333;
    margin-bottom:10px;
}

.contact-box p{
    color:#666;
    margin-bottom:40px;
}

.contact-form{
    display:grid;
    grid-template-columns:1fr 1fr;
    gap:20px;
}

.contact-form input,
.contact-form textarea{
    width:100%;
    padding:16px;
    border:none;
    background:#f5f5f5;
    border-radius:12px;
    font-size:16px;
    transition:.3s;
}

.contact-form textarea{
    grid-column:1/3;
    resize:none;
}

.contact-form input:focus,
.contact-form textarea:focus{
    outline:none;
    background:white;
    box-shadow:0 0 0 3px #4f8cff33;
}

.send-btn{
    grid-column:1/3;
    padding:16px;
    border:none;
    border-radius:12px;
    background:#4F8CFF;
    color:white;
    font-size:18px;
    cursor:pointer;
    transition:.3s;
}

.send-btn:hover{
    background:#2d73f5;
    transform:translateY(-2px);
}

.contact-info{
    margin-top:40px;
    display:flex;
    justify-content:space-around;
    text-align:center;
    border-top:1px solid #eee;
    padding-top:30px;
}

.contact-info div{
    flex:1;
}

.contact-info h4{
    margin-bottom:8px;
    color:#333;
}

.contact-info p{
    margin:0;
    color:#777;
}

@media(max-width:768px){

.contact-form{
    grid-template-columns:1fr;
}

.contact-form textarea,
.send-btn{
    grid-column:auto;
}

.contact-info{
    flex-direction:column;
    gap:20px;
}

}
</style>

</head>

<body>

<section id="contact">

<div class="contact-box">

<h2>📬 Contact Me</h2>

<p>
최대한 빠르게 확인 후 답변 드리겠습니다. 급한 연락은 핸드폰으로 부탁드립니다.
</p>

<!-- <form class="contact-form" id = "contactForm" action = "contact" method = "post"  > -->
<form class="contact-form"
      id="contactForm"
      action="${pageContext.request.contextPath}/contact"
      method="post">

<input type="text" id = "name" name = "name" placeholder="👤 닉네임">

<input type="email" id = "email" name = "email" placeholder="📧 이메일">

<input type="text" id = "company" name = "company" placeholder="🏢 회사(선택)">

<input type="text" id = "subject" name = "subject" placeholder="📝 주제">

<textarea rows="7" id = "message" name = "message" placeholder="💬 내용을 입력해주세요"></textarea>

<button type = "button" class="send-btn" onclick = "sendMessage()">
Send Message 🚀
</button>

</form>

</div>

</section>

<script src="js/contact.js"></script>
</body>
</html> 