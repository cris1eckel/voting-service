CREATE TABLE voting_topics
(
    id       bigserial PRIMARY KEY,
    subject  varchar      not null
);

CREATE TABLE associate_votes
(
    id       bigserial PRIMARY KEY,
    associate_code bigint NOT NUll,
    voting_topic_id bigint NOT NULL REFERENCES voting_topics(id),
    vote bool not null
);

CREATE TABLE voting_sessions
(
    id       bigserial PRIMARY KEY,
    start_date timestamp(0),
    end_date timestamp(0),
    voting_topic_id bigint NOT NULL REFERENCES voting_topics(id)
);