insert into ejournal.subject_teacher
  (id_subject, id_teacher)
values ((select id from ejournal.subject where name = 'русский'),
        (select id from ejournal.teacher where name = 'Иван' and surname = 'Иванов' and patronymic = 'Иванович'));
insert into ejournal.subject_teacher
  (id_subject, id_teacher)
values ((select id from ejournal.subject where name = 'алгебра'),
        (select id from ejournal.teacher where name = 'Пётр' and surname = 'Петров' and patronymic = 'Петрович'));
insert into ejournal.subject_teacher
  (id_subject, id_teacher)
values ((select id from ejournal.subject where name = 'английский'),
        (select id from ejournal.teacher where name = 'Сидор' and surname = 'Сидоров' and patronymic = 'Сидорович'));
insert into ejournal.subject_teacher
  (id_subject, id_teacher)
values ((select id from ejournal.subject where name = 'информатика'),
        (select id from ejournal.teacher where name = 'Флора' and surname = 'Аркебузова' and patronymic = 'Фауновна'));
insert into ejournal.subject_teacher
  (id_subject, id_teacher)
values ((select id from ejournal.subject where name = 'и компьютерная графика'),
        (select id
         from ejournal.teacher
         where name = 'Дездемона' and surname = 'Перегибова' and patronymic = 'Отелловна'));
insert into ejournal.subject_teacher
  (id_subject, id_teacher)
values ((select id from ejournal.subject where name = 'физкультура'),
        (select id from ejournal.teacher where name = 'Палыч' and surname = 'Палыч' and patronymic = 'Палыч'));