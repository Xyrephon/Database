

CREATE TABLE survey
(
id int(11) PRIMARY KEY auto_increment,
title VARCHAR (255) NOT NULL,
version int(11) NOT NULL DEFAULT 1
);

CREATE TABLE taken_survey
(
id int(11) PRIMARY KEY auto_increment,
survey_id int(11) NOT NULL,
participant_id int(11) NOT NULL,
FOREIGN KEY (survey_id) REFERENCES survey(id),
FOREIGN KEY (participant_id) REFERENCES participant(id)
);
CREATE UNIQUE INDEX svy_title_ver ON survey(title, version);

CREATE TABLE question
(
id int(11) PRIMARY KEY auto_increment,
survey_id int(11) NOT NULL,
question VARCHAR(2000) NOT NULL,
question_type enum ('MultipleChoice', 'FreeResponse'),
FOREIGN KEY (survey_id) REFERENCES survey(id)
);

CREATE TABLE answer
(
id int(11) PRIMARY KEY auto_increment,
participant_id int (11) NOT NULL,
question_id int(11) NOT NULL,
multiple_choice enum ('a','b','c','d','e'),
free_response VARCHAR(2000),
FOREIGN KEY (question_id) REFERENCES question(id),
FOREIGN KEY (participant_id) REFERENCES participant(id) ON DELETE cascade ON UPDATE cascade
)