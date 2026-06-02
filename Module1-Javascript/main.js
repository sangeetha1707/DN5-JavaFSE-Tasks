// Task 1

console.log("Welcome to the Community Portal");

window.addEventListener("load", () => {
    alert("Page Fully Loaded");
});

// Task 2

const portalName = "Local Community Event Portal";
const portalYear = "2026";
let availableSeats = 50;

console.log(`${portalName} - ${portalYear}`);

availableSeats++;

// Task 5

class Event {
    constructor(id, name, category, date, seats) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.date = date;
        this.seats = seats;
    }
}

Event.prototype.checkAvailability = function () {
    return this.seats > 0;
};

// Task 6

let events = [
    new Event(1, "Music Night", "Music", "2026-12-20", 20),
    new Event(2, "Baking Workshop", "Workshop", "2026-11-15", 15),
    new Event(3, "Sports Meet", "Sports", "2026-10-10", 25),
    new Event(4, "Photography Workshop", "Workshop", "2026-09-18", 18),
    new Event(5, "Coding Bootcamp", "Technology", "2026-08-12", 30),
    new Event(6, "Community Marathon", "Sports", "2026-07-25", 40),
    new Event(7, "Jazz Evening", "Music", "2026-06-30", 22),
    new Event(8, "Cultural Festival", "Cultural", "2026-06-15", 50)
];

// Task 10

const clonedEvents = [...events];

const musicEvents = events.filter(
    event => event.category === "Music"
);

const eventTitles = events.map(
    event => `Workshop on ${event.name}`
);

console.log(clonedEvents);
console.log(musicEvents);
console.log(eventTitles);

const [firstEvent] = events;
console.log(firstEvent);

// Task 4

function addEvent(event) {
    events.push(event);
}

function registerUser(eventId) {
    const event = events.find(
        item => item.id === eventId
    );

    if (event && event.seats > 0) {
        event.seats--;
        renderEvents();
        updateEventDropdown();
    }
}

function filterEventsByCategory(category = "all") {

    if (category === "all") {
        renderEvents(events);
        return;
    }

    const filtered = events.filter(
        event => event.category === category
    );

    renderEvents(filtered);
}

// Task 4 Closure

function registrationCounter() {

    let total = 0;

    return function () {
        total++;
        return total;
    };
}

const countRegistrations = registrationCounter();

// Task 7

const eventContainer =
    document.querySelector("#eventContainer");

function renderEvents(eventList = events) {

    eventContainer.innerHTML = "";

    eventList.forEach(event => {

        const card =
            document.createElement("div");

        card.classList.add("event-card");

        card.innerHTML = `
            <div class="event-content">
                <h3>${event.name}</h3>

                <p>
                    <strong>Category:</strong>
                    ${event.category}
                </p>

                <p>
                    <strong>Date:</strong>
                    ${event.date}
                </p>

                <p>
                    <strong>Seats Available:</strong>
                    ${event.seats}
                </p>

                <button onclick="handleRegister(${event.id})">
                    Register
                </button>
            </div>
        `;

        eventContainer.appendChild(card);
    });
}

// Task 3
function handleRegister(id) {

    const event =
        events.find(
            item => item.id === id
        );

    if (!event) {
        return;
    }

    if (event.seats <= 0) {

        alert("No seats available");

        return;
    }

    eventSelect.value =
        event.name;

    document
        .querySelector(".registration-section")
        .scrollIntoView({
            behavior: "smooth"
        });
}
// Task 8

document
    .querySelector("#categoryFilter")
    .addEventListener("change", function () {

        filterEventsByCategory(
            this.value
        );
    });

document
    .querySelector("#searchInput")
    .addEventListener("input", function () {

        const search =
            this.value.toLowerCase();

        const filtered =
            events.filter(event =>
                event.name
                    .toLowerCase()
                    .includes(search)
            );

        renderEvents(filtered);
    });

// Task 11

const form =
    document.querySelector("#registrationForm");

const eventSelect =
    document.querySelector("#eventSelect");

function updateEventDropdown() {

    eventSelect.innerHTML =
        '<option value="">Choose Event</option>';

    events.forEach(event => {

        eventSelect.innerHTML += `
            <option value="${event.name}">
                ${event.name}
            </option>
        `;
    });
}

updateEventDropdown();

form.addEventListener(
    "submit",
    function (event) {

        event.preventDefault();

        let valid = true;

        const name =
            form.elements["name"].value;

        const email =
            form.elements["email"].value;

        const selectedEvent =
            form.elements["event"].value;

        document.querySelector("#nameError").textContent = "";
        document.querySelector("#emailError").textContent = "";
        document.querySelector("#eventError").textContent = "";

        if (name.trim() === "") {

            document.querySelector("#nameError")
                .textContent = "Name is required";

            valid = false;
        }

        if (!email.includes("@")) {

            document.querySelector("#emailError")
                .textContent = "Enter a valid email";

            valid = false;
        }

        if (selectedEvent === "") {

            document.querySelector("#eventError")
                .textContent = "Select an event";

            valid = false;
        }

        if (valid) {

            sendRegistration({
                name,
                email,
                selectedEvent
            });

            form.reset();
        }
    }
);

// Task 9

async function fetchEvents() {

    const spinner =
        document.querySelector("#loadingSpinner");

    spinner.classList.remove("hidden");

    try {

        const result =
            await new Promise(resolve => {

                setTimeout(() => {
                    resolve(events);
                }, 1000);

            });

        renderEvents(result);

    } catch (error) {

        console.log(error);

    } finally {

        spinner.classList.add("hidden");
    }
}

// Task 12

function sendRegistration(data) {

    document.querySelector("#messageBox")
        .textContent =
        "Submitting registration...";

    const selectedEvent =
        events.find(
            event =>
                event.name ===
                data.selectedEvent
        );

    setTimeout(() => {

        fetch(
            "https://jsonplaceholder.typicode.com/posts",
            {
                method: "POST",
                headers: {
                    "Content-Type":
                        "application/json"
                },
                body:
                    JSON.stringify(data)
            }
        )
            .then(response =>
                response.json()
            )
            .then(result => {

                console.log(result);

                if (
                    selectedEvent &&
                    selectedEvent.seats > 0
                ) {

                    selectedEvent.seats--;

                    renderEvents();

                    updateEventDropdown();
                }

                document.querySelector(
                    "#messageBox"
                ).textContent =
                    "Registration Successful";
            })
            .catch(error => {

                console.log(error);

                document.querySelector(
                    "#messageBox"
                ).textContent =
                    "Registration Failed";
            });

    }, 1500);
}
// Task 13

console.log("Debugging Enabled");

console.log(
    Object.entries(events[0])
);

// Task 14

$(document).ready(function () {

    $("#categoryFilter").change(function () {

        $("#eventContainer")
            .fadeOut(200, function () {

                $(this).fadeIn(400);

            });

    });

    $("#registerBtn").click(function () {

        $("#messageBox")
            .hide()
            .fadeIn(500);

    });

});

// Initial Load

fetchEvents();