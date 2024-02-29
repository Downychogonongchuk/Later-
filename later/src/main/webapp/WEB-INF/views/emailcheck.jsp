
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <title>Email 중복 체크</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $('#email').on('input', function () {
                var email = $(this).val();
                $.ajax({
                    type: "GET",
                    url: "/emailcheck",
                    data: {email: email},
                    success: function (response) {
                        if (response === 'true') {
                            $('#emailError').text('사용 가능한 이메일입니다.');
                        } else {
                            $('#emailError').text('중복된 이메일입니다.');
                        }
                    },
                    error: function () {
                        $('#emailError').text('이메일 중복 체크에 실패했습니다.');
                    }
                });
            });
        });
    </script>
</head>
</body>
	<div>
    <label for="email">이메일:</label>
    <input type="text" id="email" name="email">
    <div id="emailError" style="color: red;">
    </div>
</body>
</html>
</body>
</html>