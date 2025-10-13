# projectOOP
```
ev-battery-swap-system/
│
├── api-gateway/               # Service cổng API Gateway
│   ├── src/
│   ├── pom.xml
│
├── discovery-server/          # Eureka Service Discovery
│   ├── src/
│   ├── pom.xml
│
├── config-server/             # Config Server cho microservices
│   ├── src/
│   ├── pom.xml
│
├── user-service/              # Quản lý người dùng (Driver, Staff, Admin)
│   ├── src/
│   ├── pom.xml
│
├── station-service/           # Quản lý trạm đổi pin
│   ├── src/
│   ├── pom.xml
│
├── battery-service/           # Quản lý pin, trạng thái, SoH
│   ├── src/
│   ├── pom.xml
│
├── transaction-service/       # Giao dịch đổi pin
│   ├── src/
│   ├── pom.xml
│
├── payment-service/           # Thanh toán, gói thuê pin
│   ├── src/
│   ├── pom.xml
│
├── report-service/            # Báo cáo, AI dự đoán nhu cầu
│   ├── src/
│   ├── pom.xml
│
├── docker-compose.yml         # Dùng để chạy tất cả container (MySQL, các service, gateway)
├── config-repo/               # Lưu các file cấu hình (.properties hoặc .yml)
│   ├── application.yml
│
├── README.md
└── .gitignore
.
```

