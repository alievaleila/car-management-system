package org.example;

public class SensorSuite {
    private boolean cameraOk;
    private boolean radarOk;
    private boolean lidarOk;
    private boolean gpsOk;
    private boolean laneAssistOk;

    public SensorSuite(boolean cameraOk, boolean gpsOk, boolean laneAssistOk, boolean lidarOk, boolean radarOk) {
        this.cameraOk = cameraOk;
        this.gpsOk = gpsOk;
        this.laneAssistOk = laneAssistOk;
        this.lidarOk = lidarOk;
        this.radarOk = radarOk;
    }

    public boolean isCameraOk() {
        return cameraOk;
    }

    public void setCameraOk(boolean cameraOk) {
        this.cameraOk = cameraOk;
    }

    public boolean isGpsOk() {
        return gpsOk;
    }

    public void setGpsOk(boolean gpsOk) {
        this.gpsOk = gpsOk;
    }

    public boolean isLaneAssistOk() {
        return laneAssistOk;
    }

    public void setLaneAssistOk(boolean laneAssistOk) {
        this.laneAssistOk = laneAssistOk;
    }

    public boolean isLidarOk() {
        return lidarOk;
    }

    public void setLidarOk(boolean lidarOk) {
        this.lidarOk = lidarOk;
    }

    public boolean isRadarOk() {
        return radarOk;
    }

    public void setRadarOk(boolean radarOk) {
        this.radarOk = radarOk;
    }

    public boolean allOk() {
        return isCameraOk() && isGpsOk() && isRadarOk() && isLidarOk() && isLaneAssistOk();
    }
}
