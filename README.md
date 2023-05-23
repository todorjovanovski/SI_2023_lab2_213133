# Todor Jovanovski, 213133

Втора лабораториска вежба по Софтверско инженерство

# Control Flow Graph:

  ![CFG](https://github.com/todorjovanovski/SI_2023_lab2_213133/assets/116504673/52b80b69-f922-4eb3-9f99-882b5a830999)

# Цикломатска комплексност:

Цикломатската комплексност на овој граф изнесува 11. Може да се пресмета како број на затворени региони, број на предикатни (разгранувачки) јазли + 1 или број на ребра - број на јазли + 2.

# Every Branch:

За да ги покриеме сите разгранувања според Every Branch критериумот доволни ни се 4 тест случаи. Пример:
  1. user = null
  2. user.username = null, user.email = jondoe@mail.com, password = "asd1234#", users = {(user1.email = "jondoe@mail.com", user1.username = jondoe@mail.com, user1.password = ...), (user2.mail = moe@mail.com,          user2.username = moE, user2.password = ...)}
  3. user.username = jondoe, user.email = jondoe.mail.com, user.password = "jondoe", users = {...}
  4. user.username = ..., user.email = ..., user.password = "jondoe 1", users = {...}

* ... -> може произволна вредност за променливите.

Со првиот го покриваме гранењето за исклучокот. Со вториот тест случај ги покриваме гранењето за непостоечки username, правилен е-mail како и гранењата во вгнездениот for-циклус, гранењето за лозинка без празно место како и for-циклусот и проверката за специјални карактери. Гранењата за постоечки username, неправилен e-mail, како и лозинка пократка од 8 карактери ги покриваме со третиот тест случај. Финално, со последниот тест случај го опфаќаме гранењето за лозинка со празно место.


# Multiple Condition:

За да ги опфатиме сите тест случаи според multiple condition критериумот потребо е да ги исполниме следните услови (со примери):

  condition -> if (user==null || user.getPassword()==null || user.getEmail()==null)
  
1. Т * * - user = null
2. F T * - user != null, user.password = null
3. F F T - user != null, user.password = jondoe, user.mail = null
4. F F F - user != null, user.password = jondoe, user.mail = jondoe@mail.com

* T - true, F - false за секоја променлива соодветно

# Unit tests:

Unit тестовите се напишани користејќи го ЈUnit dependecу-то. За исклучокот ги користев методите asserthThrows и assertDoesNotThrow, а за останатите методи доволни беа функциите assertTrue и assertFalse.
