ALTER TABLE ejournal.pupil DROP CONSTRAINT IF EXISTS pupil_unq;
ALTER TABLE ejournal.pupil ADD CONSTRAINT pupil_unq UNIQUE ("name",surname,patronymic,description);