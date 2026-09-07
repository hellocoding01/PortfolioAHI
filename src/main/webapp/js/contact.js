function sendMessage() {
    const name = document.getElementById("name").value.trim();
    const email = document.getElementById("email").value.trim();
    const company = document.getElementById("company").value.trim();
    const subject = document.getElementById("subject").value.trim();
    const message = document.getElementById("message").value.trim();
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

	if (!emailRegex.test(email)) {
   		 alert("올바른 이메일 형식을 입력해주세요.");
  		  return;
	}

    if (!name) {
        alert("닉네임을 입력해주세요.");
        return;
    }

    if (!email) {
        alert("이메일을 입력해주세요.");
        return;
    }

    if (!subject) {
        alert("주제를 입력해주세요.");
        return;
    }

    if (!message) {
        alert("내용을 입력해주세요.");
        return;
    }
    
    
    document.getElementById("contactForm").submit();
    

}