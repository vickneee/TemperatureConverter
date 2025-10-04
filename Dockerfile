# Stage
FROM openjdk:17-jdk-slim

WORKDIR /app

# Install GUI + GL libraries AND X Virtual Frame Buffer (Xvfb)
# Xvfb is necessary to run GUI applications (like JavaFX) in a headless environment.
RUN apt-get update && apt-get install -y \
    libx11-6 libxext6 libxrender1 libxtst6 libxi6 \
    libxrandr2 libxinerama1 libgtk-3-0 \
    libgl1-mesa-glx libgl1-mesa-dri mesa-utils \
    fonts-dejavu wget unzip \
    xvfb \
    && rm -rf /var/lib/apt/lists/*

# Download and unzip JavaFX Linux SDK
RUN mkdir -p /javafx-sdk \
    && wget -O javafx.zip https://download2.gluonhq.com/openjfx/21.0.2/openjfx-21.0.2_linux-x64_bin-sdk.zip \
    && unzip javafx.zip -d /javafx-sdk \
    && mv /javafx-sdk/javafx-sdk-21.0.2/lib /javafx-sdk/lib \
    && rm -rf /javafx-sdk/javafx-sdk-21.0.2 javafx.zip

# Copy the shaded JAR
COPY target/TemperatureConverter-1.0-SNAPSHOT-shaded.jar app.jar

# CMD to run JavaFX app
# We use 'sh -c' to run a sequence of commands:
# 1. Start Xvfb (virtual display server) on display :99.
# 2. Export the DISPLAY variable so JavaFX knows where to render.
# 3. Run the Java application.
CMD ["sh", "-c", "Xvfb :99 -screen 0 1024x768x24 & export DISPLAY=:99 && java --module-path /javafx-sdk/lib --add-modules javafx.controls,javafx.fxml -jar app.jar"]
