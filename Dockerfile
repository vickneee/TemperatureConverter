# Stage
FROM openjdk:17-jdk-slim

WORKDIR /app

# Install GUI + GL libraries
RUN apt-get update && apt-get install -y \
    libx11-6 libxext6 libxrender1 libxtst6 libxi6 \
    libxrandr2 libxinerama1 libgtk-3-0 \
    libgl1-mesa-glx libgl1-mesa-dri mesa-utils \
    fonts-dejavu wget unzip \
    && rm -rf /var/lib/apt/lists/*

# Download and unzip JavaFX Linux SDK
RUN mkdir -p /javafx-sdk \
    && wget -O javafx.zip https://download2.gluonhq.com/openjfx/21.0.2/openjfx-21.0.2_linux-x64_bin-sdk.zip \
    && unzip javafx.zip -d /javafx-sdk \
    && mv /javafx-sdk/javafx-sdk-21.0.2/lib /javafx-sdk/lib \
    && rm -rf /javafx-sdk/javafx-sdk-21.0.2 javafx.zip

# Copy the shaded JAR
# COPY target/app.jar app.jar
COPY target/TemperatureConverter-1.0-SNAPSHOT-shaded.jar app.jar

# Force software rendering (avoid ES2 crash)
# ENV JAVAFX_PRISM_SW=true # (Removed this line as the CMD below covers it)

# CMD to run JavaFX app
# CMD ["java", "--module-path", "/javafx-sdk/lib", "--add-modules", "javafx.controls,javafx.fxml", "-jar", "app.jar"]

# CMD to run JavaFX app
# The key additions here are:
# 1. -Dglass.platform=Monocle and -Dmonocle.platform=OffScreen: Tell JavaFX to use the headless Monocle platform.
# 2. -Dprism.order=sw: Explicitly forces the software (SW) rendering pipeline.
CMD ["java", "-Dglass.platform=Monocle", "-Dmonocle.platform=OffScreen", "-Dprism.order=sw", \
    "--module-path", "/javafx-sdk/lib", "--add-modules", "javafx.controls,javafx.fxml", "-jar", "app.jar"]