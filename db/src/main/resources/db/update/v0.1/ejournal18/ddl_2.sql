ALTER TABLE ejournal.teacher DROP CONSTRAINT IF EXISTS teacher_unq;
ALTER TABLE ejournal.teacher ADD CONSTRAINT teacher_unq UNIQUE ("name",surname,patronymic,description);
