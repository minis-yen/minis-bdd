Feature: 系統登入.

Scenario: 系統登入
	Given 進入系統 > "http://localhost/login" 登入頁面
	When  輸入使用者帳號: "", 密碼: "", 點選確定登入
	Then  系統登入後將進入主頁面
	And   登出系統 > "http://localhost/logout"
