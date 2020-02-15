# Clinic
Техническое задание


Разработать мобильное приложение «Поликлиника», предназначенное как для пациентов поликлиники, так и для сотрудников поликлиники, всех классов. Приложение должно быть реализовано на языке Kotlin, и должны быть реализованы следующие функции: авторизация пользователя, регистрация нового пользователя, просмотр актуального расписания врачей на выбранную дату, автоматическое определение города (для пациентов), запись на прием к нужному специалисту, запись на получение лечебно-проклитических процедур, «бан» недобросовестных пользователей, просмотр рекомендованного лечения,просмотр записанных на прием пациентов, открытие карты пациента, открытие обработанных результатах анализов пациента.


В приложении должно быть минимум 4 типов пользователей: неавторизованный пользователь, авторизованный пациент, врач, медсестра.
В разрабатываемом приложении должны быть реализованы следующие формы(минимум 4): форма авторизации, форма просмотра актуального расписания специалистов(по умолчанию на актуальную дату), форма просмотра предлагаемых услуг медицинского лечебно-профилактического учреждения, просмотр записанных на прием к конкретному специалисту пациентов, форма просмотра карты пациента, форма просмотра актуального назначенного лечения.


Обязательно использование следующих технологий: Retrofit, Room, AndroidXNavigation.


Все формы должны быть реализованы в едином стиле и иметь общий логотип, и не крашиться при перевороте экрана.
Приложение должно обрабатывать ошибки ввода, и оповещать о них. При одновременной независимой записи на прием, записывать первого пользователя, второго оповещать о занятости места и предлагать ближайшее актуальное время. Хранить актуальные рекомендации врача в телефоне, до момента снятия рекомендации.


Приложение должно взаимодействовать с Android 5.0+. 

