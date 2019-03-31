insert into ejournal.pupil (surname, name, patronymic, description, id_class)
values ('Сковородкин', 'Себастьян', 'Мафусаилович', 'проспал полимеры',
        (select id from ejournal."class" where "number" = 5 and liter = 'А'));

insert into ejournal.pupil (surname, name, patronymic, description, id_class)
values ('Бармалеева', 'Елена', 'Цокотуховна', 'любит сказки Чуковского',
        (select id from ejournal."class" where "number" = 5 and liter = 'А'));

insert into ejournal.pupil (surname, name, patronymic, description, id_class)
values ('Симпатюгина', 'Светка', 'Владленовна', 'спит на уроках',
        (select id from ejournal."class" where "number" = 5 and liter = 'А'));

insert into ejournal.pupil (surname, name, patronymic, description, id_class)
values ('Кононов', 'Дмитрий', 'Павлович', 'хорош во всём',
        (select id from ejournal."class" where "number" = 5 and liter = 'А'));

insert into ejournal.pupil (surname, name, patronymic, description, id_class)
values ('Амперметров', 'Сергей', 'Вольтметрович', 'знает физику, но не знает, зачем она ему',
        (select id from ejournal."class" where "number" = 5 and liter = 'Б'));

insert into ejournal.pupil (surname, name, patronymic, description, id_class)
values ('Майшев', 'Алексей', 'Владимирович', 'смешной и нелепый',
        (select id from ejournal."class" where "number" = 5 and liter = 'Б'));

insert into ejournal.pupil (surname, name, patronymic, description, id_class)
values ('Солодянкина', 'Галина', 'Владимировна', 'ещё не знает, во что вляпается',
        (select id from ejournal."class" where "number" = 5 and liter = 'Б'));

insert into ejournal.pupil (surname, name, patronymic, description, id_class)
values ('Владиславова', 'Владислава', 'Владиславовна', 'у родителей нет фантазии',
        (select id from ejournal."class" where "number" = 5 and liter = 'Б'));

insert into ejournal.pupil (surname, name, patronymic, description, id_class)
values ('Дылда', 'Юлия', 'Александровна', 'дылда',
        (select id from ejournal."class" where "number" = 5 and liter = 'Б'));