🚀 vtiger CRM - Enterprise Automation Framework

A high-performance Industrial-Grade Automation Framework built on the Page Object Model (POM) and Data-Driven approach. Engineered for rapid, reliable, and scalable testing of the vtiger CRM application.

🏗️ Project Architecture

The framework follows a modular structure for maximum maintainability:

vtiger-crm-framework-a13
├── 📂 src/main/java
│   ├── 📦 base_utility        # WebDriver lifecycle (BaseClass.java)
│   ├── 📦 generic_utility     # Excel, Properties, Java & WebDriver Helpers
│   ├── 📦 listeners_utility   # TestNG Listeners for screenshots & logs
│   └── 📦 object_repository    # Page Factory / POM classes
├── 📂 src/main/resources      # Configuration files
├── 📂 src/test/java           # Modular Test Scripts (Contact, Lead, Org)
├── 📂 src/test/resources      # Test Data (Excel, .properties)
└── 📄 pom.xml                 # Maven Dependency Management

🛠️ Tech Stack & Key Components
Component	Technology	Description
Language	Java	Core logic and scripting.
Automation Tool	Selenium WebDriver	Browser interaction and UI automation.
Test Engine	TestNG	Execution control, grouping, and assertions.
Design Pattern	POM	Page Object Model for optimized maintenance.
Reporting	Extent Reports	Interactive HTML reports with failure screenshots.
Build Tool	Maven	Build lifecycle and dependency management.
Data Handling	Apache POI	Robust Excel Data-Driven testing.
🌟 Framework Features
✅ Hybrid Framework: Seamlessly combines Data-Driven and Keyword-Driven methodologies.
✅ Screenshot Capture: Automatic screenshot generation for failed test cases via Listeners.
✅ Parallel Execution: Support for multi-browser testing to reduce execution time.
✅ Generic Utilities: Optimized wrappers for Waits, Dropdowns, and Pop-up handling.
✅ Zero Hardcoding: All environment variables and test data are externalized in .properties or .xlsx.
🚀 Quick Start Guide
1. Prerequisites
IDE: IntelliJ IDEA or Eclipse.
Java: JDK 11 or higher.
Maven: Configured in System Environment Variables.
2. Setup
# Clone the repository
git clone https://github.com/Rakshit-Automation/vtiger-crm-framework-a4.git

# Navigate to project directory
cd vtiger-crm-framework-a4

# Clean and Install dependencies
mvn clean install
3. Execution
Tests can be executed through the following methods:

IDE: Right-click on any test class in src/test/java -> Run as TestNG Test.
Command Line (CLI):
mvn test -DsuiteXmlFile=testng.xml
📊 Reporting
After execution, the detailed report is generated at: test-output/ExtentReport/index.html

The report includes step-by-step logs, execution status, and embedded failure screenshots.

👨‍💻 Author
Rakshit Tiwari

GitHub: @AutomationWithPiyushhh
Role: QA Automation Engineer
