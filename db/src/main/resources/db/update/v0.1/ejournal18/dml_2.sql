insert into ejournal.class (number, liter, id_teacher, id_period)
values (5, 'А',
        (select id from ejournal.teacher where surname = 'Иванов' and name = 'Иван' and patronymic = 'Иванович'),
        (select id
         from ejournal.period
         where id_period_type = (select id from ejournal.period_type where name = 'Год')));

insert into ejournal.class (number, liter, id_teacher, id_period)
values (5, 'Б',
        (select id from ejournal.teacher where surname = 'Петров' and name = 'Пётр' and patronymic = 'Петрович'),
        (select id
         from ejournal.period
         where id_period_type = (select id from ejournal.period_type where name = 'Год')));