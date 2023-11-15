create table if not exists image
(
    id INT NOT NULL PRIMARY KEY,
    name varchar NOT NULL,
    person_id INT NOT NULL,
    orig_image bytea NOT NULL,
    segment_image bytea,
    detect_image bytea,
    labeled_image bytea,
    CONSTRAINT person_id_fk
    FOREIGN KEY (person_id)
    REFERENCES person(id)
)