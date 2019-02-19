CREATE TABLE ejournal.exam_teacher
(
  id         integer  NOT NULL,
  id_exam    smallint NOT NULL,
  id_teacher smallint NOT NULL
);

CREATE SEQUENCE ejournal.exam_teacher_id_seq
  AS integer
  START WITH 1
  INCREMENT BY 1
  NO MINVALUE
  NO MAXVALUE
  CACHE 1;

ALTER SEQUENCE ejournal.exam_teacher_id_seq
  OWNED BY ejournal.exam_teacher.id;

ALTER TABLE ONLY ejournal.exam_teacher
  ALTER COLUMN id SET DEFAULT nextval('ejournal.exam_teacher_id_seq' :: regclass);

SELECT pg_catalog.setval('ejournal.exam_teacher_id_seq', 1, false);

ALTER TABLE ONLY ejournal.exam_teacher
  ADD CONSTRAINT id_exam_id_teacher_ukey UNIQUE (id_exam, id_teacher);

ALTER TABLE ONLY ejournal.exam_teacher
  ADD CONSTRAINT exam_teacher_pkey PRIMARY KEY (id);

ALTER TABLE ONLY ejournal.exam_teacher
  ADD CONSTRAINT exam_teacher_id_exam_fkey FOREIGN KEY (id_exam) REFERENCES ejournal.exam (id);

ALTER TABLE ONLY ejournal.exam_teacher
  ADD CONSTRAINT exam_teacher_id_teacher_fkey FOREIGN KEY (id_teacher) REFERENCES ejournal.teacher (id);