CREATE TABLE public.class (
  id         integer  NOT NULL,
  number     smallint NOT NULL,
  liter      "char"   NOT NULL,
  id_teacher smallint NOT NULL,
  id_period  smallint NOT NULL
);

ALTER TABLE public.class
  OWNER TO postgres;

CREATE SEQUENCE public.class_id_seq
  AS integer
  START WITH 1
  INCREMENT BY 1
  NO MINVALUE
  NO MAXVALUE
  CACHE 1;

ALTER TABLE public.class_id_seq
  OWNER TO postgres;

ALTER SEQUENCE public.class_id_seq
  OWNED BY public.class.id;

------------------------------------------------------------

CREATE TABLE public.exam (
  id         integer                     NOT NULL,
  id_class   integer                     NOT NULL,
  id_subject smallint                    NOT NULL,
  datetime   timestamp without time zone NOT NULL
);

ALTER TABLE public.exam
  OWNER TO postgres;

CREATE SEQUENCE public.exam_id_seq
  AS integer
  START WITH 1
  INCREMENT BY 1
  NO MINVALUE
  NO MAXVALUE
  CACHE 1;

ALTER TABLE public.exam_id_seq
  OWNER TO postgres;

ALTER SEQUENCE public.exam_id_seq
  OWNED BY public.exam.id;

------------------------------------------------------------

CREATE TABLE public.exam_mark (
  id       integer                     NOT NULL,
  value    smallint                    NOT NULL,
  id_exam  integer                     NOT NULL,
  id_pupil integer                     NOT NULL,
  datetime timestamp without time zone NOT NULL
);

ALTER TABLE public.exam_mark
  OWNER TO postgres;

CREATE SEQUENCE public.exam_mark_id_seq
  AS integer
  START WITH 1
  INCREMENT BY 1
  NO MINVALUE
  NO MAXVALUE
  CACHE 1;

ALTER TABLE public.exam_mark_id_seq
  OWNER TO postgres;

ALTER SEQUENCE public.exam_mark_id_seq
  OWNED BY public.exam_mark.id;

--------------------------------------------------------------

CREATE TABLE public.homework (
  id                 integer NOT NULL,
  id_lesson_receive  integer NOT NULL,
  id_lesson_complete integer,
  description        text    NOT NULL
);

ALTER TABLE public.homework
  OWNER TO postgres;

CREATE SEQUENCE public.homework_id_seq
  AS integer
  START WITH 1
  INCREMENT BY 1
  NO MINVALUE
  NO MAXVALUE
  CACHE 1;

ALTER TABLE public.homework_id_seq
  OWNER TO postgres;

ALTER SEQUENCE public.homework_id_seq
  OWNED BY public.homework.id;

------------------------------------------------------------

CREATE TABLE public.lesson (
  id           integer NOT NULL,
  id_timetable integer NOT NULL,
  date         date    NOT NULL,
  comment      text
);

ALTER TABLE public.lesson
  OWNER TO postgres;

CREATE SEQUENCE public.lesson_id_seq
  AS integer
  START WITH 1
  INCREMENT BY 1
  NO MINVALUE
  NO MAXVALUE
  CACHE 1;

ALTER TABLE public.lesson_id_seq
  OWNER TO postgres;

ALTER SEQUENCE public.lesson_id_seq
  OWNED BY public.lesson.id;

------------------------------------------------------------

CREATE TABLE public.lesson_mark (
  id          integer                     NOT NULL,
  value       smallint                    NOT NULL,
  id_pupil    integer                     NOT NULL,
  id_lesson   integer,
  id_homework integer,
  id_test     integer,
  comment     character varying(200),
  datetime    timestamp without time zone NOT NULL
);

ALTER TABLE public.lesson_mark
  OWNER TO postgres;

CREATE SEQUENCE public.lesson_mark_id_seq
  AS integer
  START WITH 1
  INCREMENT BY 1
  NO MINVALUE
  NO MAXVALUE
  CACHE 1;

ALTER TABLE public.lesson_mark_id_seq
  OWNER TO postgres;

ALTER SEQUENCE public.lesson_mark_id_seq
  OWNED BY public.lesson_mark.id;

------------------------------------------------------------

CREATE TABLE public.lesson_period (
  id         integer                NOT NULL,
  number     smallint               NOT NULL,
  time_start time without time zone NOT NULL,
  time_end   time without time zone NOT NULL,
  shift      smallint               NOT NULL
);

ALTER TABLE public.lesson_period
  OWNER TO postgres;

CREATE SEQUENCE public.lesson_period_id_seq
  AS integer
  START WITH 1
  INCREMENT BY 1
  NO MINVALUE
  NO MAXVALUE
  CACHE 1;

ALTER TABLE public.lesson_period_id_seq
  OWNER TO postgres;

ALTER SEQUENCE public.lesson_period_id_seq
  OWNED BY public.lesson_period.id;

------------------------------------------------------------

CREATE TABLE public.period (
  id             integer  NOT NULL,
  id_period_type smallint NOT NULL,
  date_start     date     NOT NULL,
  date_end       date     NOT NULL
);

ALTER TABLE public.period
  OWNER TO postgres;

CREATE SEQUENCE public.period_id_seq
  AS integer
  START WITH 1
  INCREMENT BY 1
  NO MINVALUE
  NO MAXVALUE
  CACHE 1;

ALTER TABLE public.period_id_seq
  OWNER TO postgres;

ALTER SEQUENCE public.period_id_seq
  OWNED BY public.period.id;

------------------------------------------------------------

CREATE TABLE public.period_mark (
  id         integer                     NOT NULL,
  value      smallint                    NOT NULL,
  id_pupil   bigint                      NOT NULL,
  id_subject smallint                    NOT NULL,
  id_period  smallint                    NOT NULL,
  datetime   timestamp without time zone NOT NULL
);

ALTER TABLE public.period_mark
  OWNER TO postgres;

CREATE SEQUENCE public.period_mark_id_seq
  AS integer
  START WITH 1
  INCREMENT BY 1
  NO MINVALUE
  NO MAXVALUE
  CACHE 1;

ALTER TABLE public.period_mark_id_seq
  OWNER TO postgres;

ALTER SEQUENCE public.period_mark_id_seq
  OWNED BY public.period_mark.id;

------------------------------------------------------------

CREATE TABLE public.period_type (
  id   integer               NOT NULL,
  name character varying(30) NOT NULL
);

ALTER TABLE public.period_type
  OWNER TO postgres;

CREATE SEQUENCE public.period_type_id_seq
  AS integer
  START WITH 1
  INCREMENT BY 1
  NO MINVALUE
  NO MAXVALUE
  CACHE 1;

ALTER TABLE public.period_type_id_seq
  OWNER TO postgres;

ALTER SEQUENCE public.period_type_id_seq
  OWNED BY public.period_type.id;

------------------------------------------------------------

CREATE TABLE public.pupil (
  id          integer               NOT NULL,
  description text,
  id_class    integer               NOT NULL,
  name        character varying(30) NOT NULL,
  surname     character varying(30) NOT NULL,
  patronymic  character varying(30) NOT NULL
);

ALTER TABLE public.pupil
  OWNER TO postgres;

CREATE SEQUENCE public.pupil_id_seq
  AS integer
  START WITH 1
  INCREMENT BY 1
  NO MINVALUE
  NO MAXVALUE
  CACHE 1;

ALTER TABLE public.pupil_id_seq
  OWNER TO postgres;

ALTER SEQUENCE public.pupil_id_seq
  OWNED BY public.pupil.id;

------------------------------------------------------------

CREATE TABLE public.subject (
  id   smallint               NOT NULL,
  name character varying(150) NOT NULL
);

ALTER TABLE public.subject
  OWNER TO postgres;

CREATE SEQUENCE public.subject_id_seq
  AS integer
  START WITH 1
  INCREMENT BY 1
  NO MINVALUE
  NO MAXVALUE
  CACHE 1;

ALTER TABLE public.subject_id_seq
  OWNER TO postgres;

ALTER SEQUENCE public.subject_id_seq
  OWNED BY public.subject.id;

------------------------------------------------------------

CREATE TABLE public.subject_teacher (
  id         integer  NOT NULL,
  id_subject smallint NOT NULL,
  id_teacher smallint NOT NULL
);

ALTER TABLE public.subject_teacher
  OWNER TO postgres;

CREATE SEQUENCE public.subject_teacher_id_seq
  AS integer
  START WITH 1
  INCREMENT BY 1
  NO MINVALUE
  NO MAXVALUE
  CACHE 1;

ALTER TABLE public.subject_teacher_id_seq
  OWNER TO postgres;

ALTER SEQUENCE public.subject_teacher_id_seq
  OWNED BY public.subject_teacher.id;

------------------------------------------------------------

CREATE TABLE public.teacher (
  id          integer               NOT NULL,
  name        character varying(30) NOT NULL,
  surname     character varying(30) NOT NULL,
  patronymic  character varying(30) NOT NULL,
  description text
);

ALTER TABLE public.teacher
  OWNER TO postgres;

CREATE SEQUENCE public.teacher_id_seq
  AS integer
  START WITH 1
  INCREMENT BY 1
  NO MINVALUE
  NO MAXVALUE
  CACHE 1;

ALTER TABLE public.teacher_id_seq
  OWNER TO postgres;

ALTER SEQUENCE public.teacher_id_seq
  OWNED BY public.teacher.id;

------------------------------------------------------------

CREATE TABLE public.test (
  id        integer NOT NULL,
  id_lesson integer NOT NULL
);

ALTER TABLE public.test
  OWNER TO postgres;

CREATE SEQUENCE public.test_id_seq
  AS integer
  START WITH 1
  INCREMENT BY 1
  NO MINVALUE
  NO MAXVALUE
  CACHE 1;

ALTER TABLE public.test_id_seq
  OWNER TO postgres;

ALTER SEQUENCE public.test_id_seq
  OWNED BY public.test.id;

------------------------------------------------------------

CREATE TABLE public.timetable (
  id               integer  NOT NULL,
  id_class         integer  NOT NULL,
  id_subject       integer  NOT NULL,
  id_teacher       smallint NOT NULL,
  id_lesson_period smallint NOT NULL,
  id_period        smallint NOT NULL,
  day_of_week      smallint NOT NULL
);

ALTER TABLE public.timetable
  OWNER TO postgres;

CREATE SEQUENCE public.timetable_id_seq
  AS integer
  START WITH 1
  INCREMENT BY 1
  NO MINVALUE
  NO MAXVALUE
  CACHE 1;

ALTER TABLE public.timetable_id_seq
  OWNER TO postgres;

ALTER SEQUENCE public.timetable_id_seq
  OWNED BY public.timetable.id;

------------------------------------------------------------

ALTER TABLE ONLY public.class
  ALTER COLUMN id SET DEFAULT nextval('public.class_id_seq' :: regclass);


ALTER TABLE ONLY public.exam
  ALTER COLUMN id SET DEFAULT nextval('public.exam_id_seq' :: regclass);


ALTER TABLE ONLY public.exam_mark
  ALTER COLUMN id SET DEFAULT nextval('public.exam_mark_id_seq' :: regclass);


ALTER TABLE ONLY public.homework
  ALTER COLUMN id SET DEFAULT nextval('public.homework_id_seq' :: regclass);


ALTER TABLE ONLY public.lesson
  ALTER COLUMN id SET DEFAULT nextval('public.lesson_id_seq' :: regclass);


ALTER TABLE ONLY public.lesson_mark
  ALTER COLUMN id SET DEFAULT nextval('public.lesson_mark_id_seq' :: regclass);


ALTER TABLE ONLY public.lesson_period
  ALTER COLUMN id SET DEFAULT nextval('public.lesson_period_id_seq' :: regclass);


ALTER TABLE ONLY public.period
  ALTER COLUMN id SET DEFAULT nextval('public.period_id_seq' :: regclass);


ALTER TABLE ONLY public.period_mark
  ALTER COLUMN id SET DEFAULT nextval('public.period_mark_id_seq' :: regclass);


ALTER TABLE ONLY public.period_type
  ALTER COLUMN id SET DEFAULT nextval('public.period_type_id_seq' :: regclass);


ALTER TABLE ONLY public.pupil
  ALTER COLUMN id SET DEFAULT nextval('public.pupil_id_seq' :: regclass);


ALTER TABLE ONLY public.subject
  ALTER COLUMN id SET DEFAULT nextval('public.subject_id_seq' :: regclass);


ALTER TABLE ONLY public.subject_teacher
  ALTER COLUMN id SET DEFAULT nextval('public.subject_teacher_id_seq' :: regclass);


ALTER TABLE ONLY public.teacher
  ALTER COLUMN id SET DEFAULT nextval('public.teacher_id_seq' :: regclass);


ALTER TABLE ONLY public.test
  ALTER COLUMN id SET DEFAULT nextval('public.test_id_seq' :: regclass);


ALTER TABLE ONLY public.timetable
  ALTER COLUMN id SET DEFAULT nextval('public.timetable_id_seq' :: regclass);

------------------------------------------------------------

SELECT pg_catalog.setval('public.class_id_seq', 1, false);

SELECT pg_catalog.setval('public.exam_id_seq', 1, false);

SELECT pg_catalog.setval('public.exam_mark_id_seq', 1, false);

SELECT pg_catalog.setval('public.homework_id_seq', 1, false);

SELECT pg_catalog.setval('public.lesson_id_seq', 1, false);

SELECT pg_catalog.setval('public.lesson_mark_id_seq', 1, false);

SELECT pg_catalog.setval('public.lesson_period_id_seq', 1, false);

SELECT pg_catalog.setval('public.period_id_seq', 1, false);

SELECT pg_catalog.setval('public.period_mark_id_seq', 1, false);

SELECT pg_catalog.setval('public.period_type_id_seq', 1, false);

SELECT pg_catalog.setval('public.pupil_id_seq', 1, false);

SELECT pg_catalog.setval('public.subject_id_seq', 1, false);

SELECT pg_catalog.setval('public.subject_teacher_id_seq', 1, false);

SELECT pg_catalog.setval('public.teacher_id_seq', 1, false);

SELECT pg_catalog.setval('public.test_id_seq', 1, false);

SELECT pg_catalog.setval('public.timetable_id_seq', 1, false);

------------------------------------------------------------

ALTER TABLE ONLY public.class
  ADD CONSTRAINT class_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.exam_mark
  ADD CONSTRAINT exam_mark_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.exam
  ADD CONSTRAINT exam_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.homework
  ADD CONSTRAINT homework_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.subject_teacher
  ADD CONSTRAINT id_subject_id_teacher_ukey UNIQUE (id_subject, id_teacher);

ALTER TABLE ONLY public.lesson_mark
  ADD CONSTRAINT lesson_mark_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.lesson_period
  ADD CONSTRAINT lesson_period_number_shift_ukey UNIQUE (number, shift);

ALTER TABLE ONLY public.lesson_period
  ADD CONSTRAINT lesson_period_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.lesson_period
  ADD CONSTRAINT lesson_period_time_end_ukey UNIQUE (time_end);

ALTER TABLE ONLY public.lesson_period
  ADD CONSTRAINT lesson_period_time_start_ukey UNIQUE (time_start);

ALTER TABLE ONLY public.lesson
  ADD CONSTRAINT lesson_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.period_mark
  ADD CONSTRAINT period_mark_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.period
  ADD CONSTRAINT period_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.period_type
  ADD CONSTRAINT period_type_name_ukey UNIQUE (name);

ALTER TABLE ONLY public.period_type
  ADD CONSTRAINT period_type_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.pupil
  ADD CONSTRAINT pupil_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.subject
  ADD CONSTRAINT subject_name_ukey UNIQUE (name);

ALTER TABLE ONLY public.subject
  ADD CONSTRAINT subject_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.subject_teacher
  ADD CONSTRAINT subject_teacher_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.teacher
  ADD CONSTRAINT teacher_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.test
  ADD CONSTRAINT test_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.timetable
  ADD CONSTRAINT timetable_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.class
  ADD CONSTRAINT class_id_period_fkey FOREIGN KEY (id_period) REFERENCES public.period (id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE ONLY public.class
  ADD CONSTRAINT class_id_teacher_fkey FOREIGN KEY (id_teacher) REFERENCES public.teacher (id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE ONLY public.exam
  ADD CONSTRAINT exam_id_class_fkey FOREIGN KEY (id_class) REFERENCES public.class (id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE ONLY public.exam
  ADD CONSTRAINT exam_id_subject_fkey FOREIGN KEY (id_subject) REFERENCES public.subject (id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE ONLY public.exam_mark
  ADD CONSTRAINT exam_mark_id_exam_fkey FOREIGN KEY (id_exam) REFERENCES public.exam (id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE ONLY public.exam_mark
  ADD CONSTRAINT exam_mark_id_pupil_fkey FOREIGN KEY (id_pupil) REFERENCES public.pupil (id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE ONLY public.homework
  ADD CONSTRAINT homework_id_lesson_complete_fkey FOREIGN KEY (id_lesson_complete) REFERENCES public.lesson (id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE ONLY public.homework
  ADD CONSTRAINT homework_id_lesson_receive_fkey FOREIGN KEY (id_lesson_receive) REFERENCES public.lesson (id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE ONLY public.lesson
  ADD CONSTRAINT lesson_id_timetable_fkey FOREIGN KEY (id_timetable) REFERENCES public.timetable (id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE ONLY public.lesson_mark
  ADD CONSTRAINT lesson_mark_id_homework_fkey FOREIGN KEY (id_homework) REFERENCES public.homework (id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE ONLY public.lesson_mark
  ADD CONSTRAINT lesson_mark_id_lesson_fkey FOREIGN KEY (id_lesson) REFERENCES public.lesson (id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE ONLY public.lesson_mark
  ADD CONSTRAINT lesson_mark_id_pupil_fkey FOREIGN KEY (id_pupil) REFERENCES public.pupil (id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE ONLY public.lesson_mark
  ADD CONSTRAINT lesson_mark_id_test_fkey FOREIGN KEY (id_test) REFERENCES public.test (id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE ONLY public.period
  ADD CONSTRAINT period_id_period_type_fkey FOREIGN KEY (id_period_type) REFERENCES public.period_type (id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE ONLY public.period_mark
  ADD CONSTRAINT period_mark_id_period_fkey FOREIGN KEY (id_period) REFERENCES public.period (id);

ALTER TABLE ONLY public.period_mark
  ADD CONSTRAINT period_mark_id_pupil_fkey FOREIGN KEY (id_pupil) REFERENCES public.pupil (id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE ONLY public.period_mark
  ADD CONSTRAINT period_mark_id_subject_fkey FOREIGN KEY (id_subject) REFERENCES public.subject (id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE ONLY public.pupil
  ADD CONSTRAINT pupil_id_class_fkey FOREIGN KEY (id_class) REFERENCES public.class (id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE ONLY public.subject_teacher
  ADD CONSTRAINT subject_teacher_id_subject_fkey FOREIGN KEY (id_subject) REFERENCES public.subject (id);

ALTER TABLE ONLY public.subject_teacher
  ADD CONSTRAINT subject_teacher_id_teacher_fkey FOREIGN KEY (id_teacher) REFERENCES public.teacher (id);

ALTER TABLE ONLY public.test
  ADD CONSTRAINT test_id_lesson_fkey FOREIGN KEY (id_lesson) REFERENCES public.lesson (id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE ONLY public.timetable
  ADD CONSTRAINT timetable_id_class_fkey FOREIGN KEY (id_class) REFERENCES public.class (id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE ONLY public.timetable
  ADD CONSTRAINT timetable_id_lesson_period_fkey FOREIGN KEY (id_lesson_period) REFERENCES public.lesson_period (id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE ONLY public.timetable
  ADD CONSTRAINT timetable_id_subject_fkey FOREIGN KEY (id_subject) REFERENCES public.subject (id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE ONLY public.timetable
  ADD CONSTRAINT timetable_id_teacher_fkey FOREIGN KEY (id) REFERENCES public.teacher (id) ON UPDATE CASCADE ON DELETE CASCADE;

