ALTER TABLE ejournal.subject DROP CONSTRAINT IF EXISTS subject_unq;
ALTER TABLE ejournal.subject ADD CONSTRAINT subject_unq UNIQUE ("name");
