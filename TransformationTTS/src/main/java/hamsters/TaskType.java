/*
 * Copyright 2014 Racim.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package hamsters;

import java.awt.Color;

/**
 *
 * @author Racim Fahssi <Racim.Fahssi@irit.fr>
 */
public enum TaskType implements HamstersType {

    ABSTRACT("Abstract Task", "abstract", "abstrait16.png", "abstrait.png", "abstract.svg",Color.orange),
    SUBROUTINE("Subroutine", "subroutine", "abstrait16_subroutine.png", "abstrait.png", "abstract.svg",Color.white),//
    COGNITIVE("Cognitive Task", "cognitive", "cognitive16.png", "cognitive.png", "cognitive.svg",new Color(195,195,195)),
    COGNITIVE_ANALYSIS("CognitiveA Task", "cognitive_analysis", "cognitive_A_16.png", "cognitive_A.png", "cognitive_A.svg",new Color(153,153,153)),
    COGNITIVE_DECISION("CognitiveD Task", "cognitive_decision", "cognitive_D_16.png", "cognitive_D.png", "cognitive_D.svg",new Color(124,124,123)),
    SYSTEM("System Task", "system", "system16.png", "system.png", "system.svg",new Color(0,153,153)),
    MOTOR("Motor Task", "motor", "motor16.png", "motor.png", "motor.svg",new Color(153,0,0)),
    PERCEPTIVE("Perceptive Task", "perceptive", "perceptive16.png", "perceptive.png", "perceptive.svg",new Color(102,51,0)),
    USER("User Task", "user", "homme16.png", "homme.png", "homme.svg",new Color(154,78,78)),
    INTERACTIVE("Interactive Task", "interactive", "interactive16.png", "interactive.png", "interactive.svg",new Color(255,174,201)),
    INPUTOUPUT("I/O Task", "inputouput", "io16.png", "io.png", "inout.svg",new Color(0,204,0)),
    OUTPUT("Output Task", "output", "out16.png", "out.png", "output.svg",new Color(255,0,0)),
    INPUT("Input Task", "input", "in16.png", "in.png", "input.svg",new Color(0,128,0)),
    COMPONENT("Component", "component", "component16.png", "component16.png", "abstract_component.svg",Color.white),//
    TASKGROUPABSTRACT("Abstract Group Task", "taskgroupabstract", "taskgroupAbstract16.png", "taskgroupAbstract16.png", "taskgroupAbstract.svg",Color.orange),
    TASKGROUP("Group Task", "taskgroup", "taskgroup16.png", "taskgroup16.png", "taskgroup.svg",Color.orange),
    TASKGROUPINTERACTIVE("Interactive Group Task", "taskgroupinteractive", "taskgroupinteractive16.png", "taskgroupinteractive16.png", "taskgroupinteractive.svg",new Color(255,174,201)),
    TASKGROUPHYBRID("Hybrid Group Task", "taskgrouphybrid", "hybridGroupTask16.png", "hybridGroupTask16.png", "hybridGroupTask.svg",new Color(102,255,102)),
    USERCOORDINATION("User Coor Task", "usercoordination", "hommecooperation16.png", "hommecooperation16.png", "hommecooperation.svg",new Color(154,78,78)),
    INTERACTIVECOORDINATION("Interactive Coor Task", "interactivecoordination", "interactivecoordination16.png", "interactivecoordination16.png", "interactivecoordination.svg",new Color(255,174,201)),
    INPUTCOORDINATION("Input Coor Task", "inputcoordination", "inputcoordination16.png", "inputcoordination16.png", "inputcoordination.svg",new Color(0,128,0)),
    OUTPUTCOORDINATION("Output Coor Task", "outputcoordination", "outputcoordination16.png", "outputcoordination16.png", "outputcoordination.svg",new Color(255,0,0)),
    COOPERATIVEMOTOR("Motor Coor Task", "cooperativemotor", "CooperativeMotor16.png", "CooperativeMotor16.png", "CooperativeMotor.svg",new Color(153,0,0)),
    COOPERATIVECOGNITIVE("Cognitive Coor Task", "cooperativecognitive", "CooperativeCognitive16.png", "CooperativeCognitive16.png", "CooperativeCognitive.svg",new Color(195,195,195)),
    COOPERATIVEPERCEPTIVE("Perceptive Coor Task", "cooperativeperceptive", "CooperativePerceptive16.png", "CooperativePerceptive16.png", "CooperativePerceptive.svg",new Color(102,51,0)),
    ABSTRACTCOOPERATIVEUSER("Abstract Coor User Task", "abstractcooperativeuser", "AbstractCooperativeUser16.png", "AbstractCooperativeUser16.png", "AbstractCooperativeUser.svg",Color.WHITE),
    ABSTRACTUSER("Abstract User Task", "abstractuser", "AbstractUser16.png", "AbstractUser16.png", "AbstractUser.svg",Color.WHITE),
    ABSTRACTSYSTEM("Abstract System Task", "abstractsystem", "AbstractSystem16.png", "AbstractSystemt16.png", "AbstractSystem.svg",Color.WHITE),
    GROUPSYSTEM("Group System Task", "groupsystem", "GroupSystem16.png", "GroupSystem16.png", "GroupSystem.svg",new Color(0,153,153));

    private final String smallIconString;
    private final String largeIconString;
    private final String svgIconString;
    private final String name;
    private final String description;
    private  Color color;

    TaskType(final String description, final String name, final String small, final String large, final String svg,Color couleur) {
        this.description = description;
        this.name = name;
        this.smallIconString = small;
        this.largeIconString = large;
        this.svgIconString = svg;
        this.color=couleur;
    }

    private final String PALETTE_PATH = "fr/irit/hamsters/palette/";

    public String getSmallIconString() {
        return PALETTE_PATH + smallIconString;
    }

    public String getLargeIconString() {
        return PALETTE_PATH + largeIconString;
    }

    public String getSvgIconString() {
        return PALETTE_PATH + svgIconString;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public static TaskType getType(String s) {
        for (TaskType t : values()) {
            if (t.getName().equals(s)) {
                return t;
            }
        }
        return ABSTRACT;
    }
    
    public void setColor(Color c){
        this.color=c;
    }
    
    public Color getColor(){
        return this.color;
    }
    
}
