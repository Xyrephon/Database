CREATE TABLE participant 
(
id INT(11) PRIMARY KEY auto_increment,
first_name VARCHAR(255) NOT NULL,
last_name VARCHAR(255) NOT NULL,
gender ENUM('Male', 'Female') NOT NULL
);
CREATE TABLE contact_info
(
id INT(11) PRIMARY KEY auto_increment,
contact_type VARCHAR(255) NOT NULL,
contact_info VARCHAR(255) NOT NULL,
participant_id INT(11) NOT NULL,
FOREIGN KEY (participant_id) REFERENCES participant(id) ON DELETE cascade ON UPDATE cascade
);
CREATE TABLE parent
(
id INT(11) PRIMARY KEY auto_increment,
parent_id INT(11) NOT NULL,
child_id INT(11) NOT NULL,
FOREIGN KEY (child_id) REFERENCES participant(id),
FOREIGN KEY (parent_id) REFERENCES participant(id)
);

