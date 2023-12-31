CREATE TABLE users (
    username VARCHAR(20) NOT NULL UNIQUE, 
    password VARCHAR(20) NOT NULL,
    weight INTEGER,  
    height_inches INTEGER,
    fitness_goal INTEGER,
    days INTEGER,
    PRIMARY KEY(username)
);

CREATE TABLE exercises (
    exercise_id INTEGER NOT NULL UNIQUE,
    exercise_name VARCHAR(100) NOT NULL,
    exercise_description VARCHAR(400) NOT NULL,
    exercise_link VARCHAR(400) NOT NULL,
    exercise_muscle_group1 VARCHAR(10) NOT NULL,
    exercise_muscle_group2 VARCHAR(10),
    exercise_muscle_group3 VARCHAR(10),
    PRIMARY KEY (exercise_id)
);

CREATE TABLE workouts (
    workout_id INTEGER NOT NULL,
    exercise_id INTEGER NOT NULL REFERENCES exercises (exercise_id),
    PRIMARY KEY (workout_id, exercise_id)
);

CREATE TABLE assignments (
    username VARCHAR(20) NOT NULL REFERENCES users (username) ON DELETE CASCADE,
    workout_id INTEGER NOT NULL,
    date_assigned DATE NOT NULL,
    date_completed DATE, 
    reps INTEGER NOT NULL,
    sets INTEGER NOT NULL,
    rest_periods INTEGER NOT NULL,
    PRIMARY KEY (username, workout_id, date_assigned)
);