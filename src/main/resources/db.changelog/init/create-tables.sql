CREATE TABLE voting_topics
(
    id       bigserial PRIMARY KEY,
    subject  varchar      not null
);

CREATE TABLE users
(
    id       bigserial PRIMARY KEY,
    name  varchar      not null,
    national_id  varchar      not null
);

CREATE TABLE associate_votes
(
    id       bigserial PRIMARY KEY,
    user_id bigint NOT NULL REFERENCES users(id),
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