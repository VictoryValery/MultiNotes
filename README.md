# MultiNotes

Задача: создать многомодульное приложение заметок с экранами авторизации, дашбордом заметок и редактором заметок.
Всего должно быть 4 модуля (app, auth, dashboard, note).

# Требования к экранам

**Экран авторизации**:
* Поля для ввода логина и пароля
* Кнопка для подтверждения входа
* Логин и пароль сохраняем в памяти для дальнейшего использования
* Нужна проверка на незаполненные данные для полей ввода (для упрощения ничего не показываем, а просто не пускаем дальше пользователя)

**Экран дашборд**:
* Сверху в тулбара необходимо отображать имя авторизованного пользователя
* Ниже идет список заметок. Если их нет, то показываем текст “нет заметок” по центру экрана
* Кнопка добавления заметки (floating button)
* Заметки можно или добавить или удалить
* Кнопка назад  -> выход из приложения

**Экран редактора заметок**:
* Текстовое поле в 6 строчек и кнопка сохранить
* Нельзя создать пустую заметку (даже проблемы и переходы на новую строку считаем пустой заметкой)
* После сохранения автоматически попадаем на дашборд
* Созданная заметка должна быть в списке заметок