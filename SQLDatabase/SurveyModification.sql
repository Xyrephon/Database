DROP TABLE IF EXISTS answer;
CREATE TABLE answer
(
id int(11) PRIMARY KEY auto_increment,
question_id int(11) NOT NULL,
response VARCHAR(2000),
FOREIGN KEY (question_id) REFERENCES question(id)
);

CREATE TABLE participant_answer
(
id int(11) PRIMARY KEY auto_increment,
participant_id int (11) NOT NULL,
answer_id int (11) NOT NULL,
FOREIGN KEY (answer_id) REFERENCES answer(id),
FOREIGN KEY (participant_id) REFERENCES participant(id) ON DELETE cascade ON UPDATE cascade
);

ALTER TABLE taken_survey ADD COLUMN taken_date timestamp NOT NULL DEFAULT current_timestamp;

ALTER TABLE question MODIFY question_type VARCHAR(255);