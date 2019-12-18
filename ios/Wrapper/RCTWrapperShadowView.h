//
//  RCTWrapperShadowView.h
//  NativeComp
//
//  Created by adrian.hartanto on 16/12/19.
//  Copyright © 2019 Facebook. All rights reserved.
//

#import <UIKit/UIKit.h>

#import <React/RCTShadowView.h>

@class RCTBridge;

NS_ASSUME_NONNULL_BEGIN

@interface RCTWrapperShadowView : RCTShadowView

- (instancetype)initWithBridge:(RCTBridge *)bridge NS_DESIGNATED_INITIALIZER;

@end

NS_ASSUME_NONNULL_END
