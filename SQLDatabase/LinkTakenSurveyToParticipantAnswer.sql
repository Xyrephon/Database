ALTER TABLE participant_answer ADD COLUMN taken_survey_id int(11);
#UPDATE participant_answer SET taken_survey_id = 1 WHERE id >= 1;
ALTER TABLE participant_answer ADD CONSTRAINT foreign key(taken_survey_id) REFERENCES taken_survey(id);