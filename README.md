# GoRide — Taxi Ride-Hailing App

A modern ride-hailing web application built with **Spring Boot 4.0.6**, **Java 21**, **MySQL**, **JPA/Hibernate**, and **JSP** with a light amber-themed UI.

## Features

### Passenger
- Book a ride (pickup, drop-off, vehicle type, fare)
- View booking history with status tracking
- Cancel active bookings
- Profile management (name, phone, passenger type)
- Payment info (card number, expiry)

### Driver
- **Dispatch Tasks** — view available ride requests, accept, mark in-progress, and complete
- **Fleet Management** — add/update/delete vehicles (make, model, year, plate, type, status)
- Dashboard with count stats for pending tasks, active tasks, and owned vehicles

### Admin
- Dashboard with system-wide counts (passengers, drivers, bookings, vehicles)
- Manage passengers — search, edit, delete
- Manage drivers — add, edit, delete, track status
- Manage all bookings — view, cancel
- Fleet management — add vehicles assigned to any driver or company, toggle active/inactive, delete
- Owner name shown instead of raw ID in vehicle list

### General
- Role-based authentication (Passenger / Driver / Admin / Company)
- Landing page with parallax hero, feature cards, animated stats counters, and CTA section
- Light theme with amber (`#f59e0b`) accent palette
- Lucide icons via CDN (no build step)
- Responsive sidebar navigation for all roles

## Tech Stack

| Layer | Technology |
|---|---|
| Backend | Spring Boot 4.0.6, Java 21 |
| Database | MySQL with JPA/Hibernate (ddl-auto: update) |
| Views | JSP with JSTL, served on `/WEB-INF/views/` |
| Frontend | Inter font, Lucide icons (CDN), vanilla JS |
| Build | Maven Wrapper |
| Server Port | `8090` |

## Getting Started

### Prerequisites

- Java 21+
- MySQL running on `localhost:3306`
- Maven (or use the included `mvnw` wrapper)

### Database Setup

Create the database:

```sql
CREATE DATABASE taxi_app;
```

Update credentials in `src/main/resources/application.properties` if needed:

```properties
spring.datasource.username=root
spring.datasource.password=your_password
```

### Run

```bash
./mvnw spring-boot:run
```

The app starts at [http://localhost:8090](http://localhost:8090).

### Seed Account

An admin account is auto-created on first run:

| Email | Password |
|---|---|
| `admin@taxi.com` | `admin123` |

Register new passenger/driver accounts from the login page.

## Project Structure

```
src/main/java/com/taxi/app/
├── config/          # AuthFilter, WebConfig, GlobalExceptionHandler, SeedDataConfig
├── controller/      # Auth, Booking, Dispatch, Fleet, Admin, Home, UserProfile, DriverManage
├── dto/             # BookingView, UserView, LoginRequest, RegisterRequest, etc.
├── model/           # Admin, Booking, Company, Driver, Passenger, Person, Vehicle
├── repository/      # JPA repositories for each entity
└── service/         # Business logic services for each domain

src/main/webapp/
├── css/style.css    # Full design system (light theme, amber palette)
├── js/
│   ├── app.js       # Shared app utilities
│   └── landing.js   # Landing page parallax + counters
└── WEB-INF/views/   # 20+ JSP views
```

## Design System

See [DESIGN.md](DESIGN.md) for the full design reference: colors, typography, spacing, border radii, and component styles.

## API Routes

### Public
| Method | Path | Description |
|---|---|---|
| GET | `/` | Landing page |
| GET | `/login` | Login form |
| POST | `/login` | Authenticate |
| GET | `/register` | Register form |
| POST | `/register` | Create account |

### Passenger (role: PASSENGER)
| Method | Path | Description |
|---|---|---|
| GET | `/home` | Dashboard redirect |
| GET | `/book` | Booking form |
| POST | `/book` | Create booking |
| GET | `/my-bookings` | Booking history |
| POST | `/bookings/cancel/{id}` | Cancel booking |
| GET | `/profile` | View/edit profile |
| POST | `/profile/edit` | Save profile |
| GET | `/payment` | Payment form |
| POST | `/payment` | Save payment info |

### Driver (role: DRIVER)
| Method | Path | Description |
|---|---|---|
| GET | `/tasks` | Dispatch task list |
| POST | `/tasks/update` | Accept/update task status |
| GET | `/fleet` | My vehicles |
| POST | `/vehicle/add` | Add vehicle |
| POST | `/vehicle/update` | Update vehicle status |
| POST | `/vehicle/delete` | Delete own vehicle |

### Admin (role: ADMIN)
| Method | Path | Description |
|---|---|---|
| GET | `/admin/dashboard` | Stats overview |
| GET | `/admin/users` | List passengers |
| POST | `/admin/users/edit` | Edit passenger |
| POST | `/admin/users/delete` | Delete passenger |
| GET | `/admin/drivers` | List drivers |
| POST | `/admin/drivers/add` | Add driver |
| POST | `/admin/drivers/edit` | Edit driver |
| POST | `/admin/drivers/delete` | Delete driver |
| GET | `/admin/bookings` | All bookings |
| POST | `/admin/bookings/delete` | Cancel booking |
| GET | `/admin/vehicles` | All vehicles |
| POST | `/admin/vehicles/add` | Add vehicle (assign owner) |
| POST | `/admin/vehicles/toggle` | Activate/deactivate |
| POST | `/vehicle/delete` | Delete any vehicle |
