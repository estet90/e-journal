ALTER TABLE ejournal.class DROP CONSTRAINT IF EXISTS class_unq;
ALTER TABLE ejournal.class ADD CONSTRAINT class_unq UNIQUE ("number", liter);
