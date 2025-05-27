create database digi_nuture;
use digi_nuture;

create table Users (user_id int primary key auto_increment,
							full_name varchar(100) not null,
                            email varchar(100) unique not null,
                            city varchar(100) not null,
                            registration_date date not null);
                            
create table Events (event_id int primary key auto_increment,
					 title varchar(200) not null,
                     description text ,
                     city varchar(100) not null,
                     start_date datetime not null,
                     end_date datetime not null,
                     status enum ('upcoming', 'completed', 'cancelled'),
                     organizer_id int ,
                     foreign key (organizer_id) references Users(user_id));

create table Sessions (session_id int primary key auto_increment,
					   event_id int,
                       title varchar(200) not null,
                       speaker_name varchar(100) not null,
                       start_time datetime not null,
                       end_time datetime not null,
                       foreign key(event_id) references Events(event_id));

create table Registrations (registration_id int primary key auto_increment,
							user_id int,
                            event_id int,
                            registration_date date not null,
                            foreign key(user_id) references Users(user_id),
                            foreign key(event_id) references Events(event_id));
                            
create table Feedback(feedback_id int primary key auto_increment,
					  user_id int,
					  event_id int,
                      ratings int check (ratings between 1 and 5),
                      comments text,
                      feedback_date date not null,
                      foreign key(user_id) references Users(user_id),
                      foreign key(event_id) references Events(event_id));


create table Resources (resource_id int primary key auto_increment,
						event_id int,
                        resource_type enum ('pdf', 'image', 'link'),
                        resource_url varchar(255) not null,
                        uploaded_at datetime not null,
                        foreign key(event_id) references Events(event_id));
                        
insert into Users values (1, "Alice Johnson", "alice@example.com", "New York", '2024-12-01');
select * from Users;
INSERT INTO Users (user_id, full_name, email, city, registration_date) VALUES
(2, 'Bob Smith', 'bob@example.com', 'Los Angeles', '2024-12-05'),
(3, 'Charlie Lee', 'charlie@example.com', 'Chicago', '2024-12-10'),
(4, 'Diana King', 'diana@example.com', 'New York', '2025-01-15'),
(5, 'Ethan Hunt', 'ethan@example.com', 'Los Angeles', '2025-02-01');

-- Events Table
INSERT INTO Events VALUES
(1, 'Tech Innovators Meetup', 'A meetup for tech enthusiasts.', 'New York', '2025-06-10 10:00:00', '2025-06-10 16:00:00', 'upcoming', 1),
(2, 'AI & ML Conference', 'Conference on AI and ML advancements', 'Chicago', '2025-05-15 09:00:00', '2025-05-15 17:00:00', 'completed', 3),
(3, 'Frontend Development Bootcamp', 'Hands-on training on frontend tech.', 'Los Angeles', '2025-07-01 10:00:00', '2025-07-03 16:00:00', 'upcoming', 2);

-- Sessions Table
INSERT INTO Sessions (session_id, event_id, title, speaker_name, start_time, end_time) VALUES
(1, 1, 'Opening Keynote', 'Dr. Tech', '2025-06-10 10:00:00', '2025-06-10 11:00:00'),
(2, 1, 'Future of Web Dev', 'Alice Johnson', '2025-06-10 11:30:00', '2025-06-10 12:30:00'),
(3, 2, 'AI in Healthcare', 'Charlie Lee', '2025-05-15 09:30:00', '2025-05-15 11:00:00'),
(4, 3, 'Intro to HTML5', 'Bob Smith', '2025-07-01 10:00:00', '2025-07-01 12:00:00');

-- Registrations Table
INSERT INTO Registrations (registration_id, user_id, event_id, registration_date) VALUES
(1, 1, 1, '2025-05-01'),
(2, 2, 1, '2025-05-02'),
(3, 4, 2, '2025-04-30'),
(4, 5, 2, '2025-04-28'),
(5, 3, 3, '2025-05-15');

-- Feedback Table
INSERT INTO Feedback  VALUES
(1, 3, 2, 4, 'Great insights!', '2025-05-16'),
(2, 4, 2, 5, 'Very informative.', '2025-05-16'),
(3, 2, 1, 3, 'Could be better.', '2025-05-11');


-- Resources Table
INSERT INTO Resources VALUES
(1, 1, 'pdf', 'https://portal.com/resources/tech_meetup_agenda.pdf', '2025-05-01 10:00:00'),
(2, 2, 'image', 'https://portal.com/resources/ai_poster.jpg', '2025-04-20 09:00:00'),
(3, 3, 'link', 'https://portal.com/resources/html5_docs', '2025-06-25 15:00:00');

select * from Feedback;


# QUERIES
-- 1.  **User Upcoming Events**
--     Show a list of all upcoming events a user is registered for in their city, sorted by date.
select e.title, e.description,  e.city, e.start_date, e.end_date, e.status 
from Events e, Users u, Registrations r 
where r.user_id = u.user_id and e.event_id = r.event_id and e.city = u.city 
order by r.registration_date;

-- 2.  **Top Rated Events**
--     Identify events with the highest average rating, considering only those that have received at least 10 feedback submissions.
select e.title, e.description,  e.city, e.start_date, e.end_date, e.status 
from Events e, Feedback f 
where e.event_id = f.event_id 
and count(f.feedback_id) >= 10
order by avg(rating) desc;

SELECT
    E.title,
    AVG(F.ratings) AS average_rating,
    COUNT(F.feedback_id) AS total_feedback
FROM
    Events AS E
JOIN
    Feedback AS F
ON
    E.event_id = F.event_id
GROUP BY
    E.event_id, E.title
HAVING
    COUNT(F.feedback_id) >= 1
ORDER BY
    average_rating DESC;

-- 3.  **Inactive Users**
--     Retrieve users who have not registered for any events in the last 90 days.

-- 4.  **Peak Session Hours**
--     Count how many sessions are scheduled between 10 AM to 12 PM for each event.
	
-- 5.  **Most Active Cities**
--     List the top 5 cities with the highest number of distinct user registrations.

-- 6.  **Event Resource Summary**
--     Generate a report showing the number of resources (PDFs, images, links) uploaded for each event.

-- 7.  **Low Feedback Alerts**
--     List all users who gave feedback with a rating less than 3, along with their comments and associated event names.

-- 8.  **Sessions per Upcoming Event**
--     Display all upcoming events with the count of sessions scheduled for them.

-- 9.  **Organizer Event Summary**
--     For each event organizer, show the number of events created and their current status (upcoming, completed, cancelled).
--     
-- **10. Feedback Gap**
-- Identify events that had registrations but received no feedback at all.

-- **11. Daily New User Count**
-- Find the number of users who registered each day in the last 7 days.

-- **12. Event with Maximum Sessions**
-- List the event(s) with the highest number of sessions.

-- **13. Average Rating per City**
-- Calculate the average feedback rating of events conducted in each city.

-- **14. Most Registered Events**
-- List top 3 events based on the total number of user registrations.

-- **15. Event Session Time Conflict**
-- Identify overlapping sessions within the same event (i.e., session start and end times that conflict).

-- **16. Unregistered Active Users**
-- Find users who created an account in the last 30 days but haven't registered for any events.

-- **17. Multi-Session Speakers**
-- Identify speakers who are handling more than one session across all events.

-- **18. Resource Availability Check**
-- List all events that do not have any resources uploaded.

-- **19. Completed Events with Feedback Summary**
-- For completed events, show total registrations and average feedback rating.

-- **20. User Engagement Index**
-- For each user, calculate how many events they attended and how many feedbacks they submitted.

-- **21. Top Feedback Providers**
-- List top 5 users who have submitted the most feedback entries.

-- **22. Duplicate Registrations Check**
-- Detect if a user has been registered more than once for the same event.

-- **23. Registration Trends**
-- Show a month-wise registration count trend over the past 12 months.

-- **24. Average Session Duration Per Event**
-- Compute the average duration (in minutes) of sessions in each event.
SELECT
    E.title AS event_title,
    AVG(TIMESTAMPDIFF(MINUTE, S.start_time, S.end_time)) AS average_session_duration_minutes
FROM
    Events AS E
JOIN
    Sessions AS S
ON
    E.event_id = S.event_id
GROUP BY
    E.event_id, E.title
ORDER BY
    E.title;

-- **25. Events Without Sessions**
-- List all events that currently have no sessions scheduled under them.
select * from Events e join Sessions s on s.event_id  != e.event_id;

SELECT e.*
FROM Events e
LEFT JOIN Sessions s ON e.event_id = s.event_id
WHERE s.event_id IS NULL;

select * from events;
insert into events values (4, "Party", "just join", "Mumbai",'2025-06-10 10:00:00', '2025-06-10 16:00:00', 'upcoming', 1);